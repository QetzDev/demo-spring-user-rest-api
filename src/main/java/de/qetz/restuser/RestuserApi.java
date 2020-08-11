package de.qetz.restuser;

import de.qetz.restuser.user.User;
import de.qetz.restuser.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.NativeWebRequest;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public final class RestuserApi implements UserApi, UsersApi {
  private final UserRepository repository;

  @Autowired
  private RestuserApi(UserRepository repository) {
    this.repository = repository;
  }

  @Override
  public ResponseEntity<UserDto> createUser(@Valid UserCreationDto userCreationDto) {
    User user = formatToUser(userCreationDto);
    if (repository.findByUserId(user.getUserId()).isPresent()) {
      return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
    }
    repository.save(user);
    return new ResponseEntity<>(formatFromUser(user), HttpStatus.OK);
  }

  @Override
  public ResponseEntity<Void> deleteUser(Integer id) {
    if (repository.findById(id).isPresent()) {
      repository.deleteById(id);
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    return new ResponseEntity<>(HttpStatus.CONFLICT);
  }

  @Override
  public ResponseEntity<UserDto> findUser(Integer id) {
    Optional<User> user = repository.findById(id);
    return user.map(value -> new ResponseEntity<>(formatFromUser(value),
      HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
  }

  @Override
  public ResponseEntity<UserDto> updateUser(
    Integer id,
    @Valid UserEmailUpdateDto eEmailUpdateDto
  ) {
    if (findUser(id).getStatusCode() == HttpStatus.OK
      && ((eEmailUpdateDto != null
      && eEmailUpdateDto.getEmail() != null
      && !eEmailUpdateDto.getEmail().isEmpty()))) {
      executeUserUpdates(id, eEmailUpdateDto);
      return new ResponseEntity<>(HttpStatus.OK);
    }
    return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
  }

  private void executeUserUpdates(int id, UserEmailUpdateDto emailUpdateDto) {
    repository.findById(id).ifPresent(user -> {
      user.setEmail(emailUpdateDto.getEmail());
      repository.save(user);
    });
  }

  @Override
  public ResponseEntity<UsersDto> findUsers() {
    List<UserDto> users = resolveAllUsers();
    UsersDto dto = new UsersDto().users(users);
    return new ResponseEntity<>(dto, HttpStatus.OK);
  }

  private List<UserDto> resolveAllUsers() {
    return repository.findAll().stream()
      .map(this::formatFromUser)
      .collect(Collectors.toList());
  }

  private User formatToUser(UserCreationDto dto) {
    return User.builder()
      .userId(dto.getUserId())
      .email(dto.getEmail())
      .build();
  }

  private UserDto formatFromUser(User user) {
    return new UserDto()
      .id(user.getId())
      .userId(user.getUserId())
      .email(user.getEmail());
  }

  @Override
  public Optional<NativeWebRequest> getRequest() {
    throw new UnsupportedOperationException();
  }
}