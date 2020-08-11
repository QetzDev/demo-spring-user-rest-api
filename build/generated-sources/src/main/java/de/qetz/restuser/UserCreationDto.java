package de.qetz.restuser;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.UUID;
import org.openapitools.jackson.nullable.JsonNullable;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * UserCreationDto
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2020-08-11T14:32:25.409171200+02:00[Europe/Berlin]")

public class UserCreationDto   {
  @JsonProperty("UserId")
  private UUID userId;

  @JsonProperty("email")
  private String email;

  public UserCreationDto userId(UUID userId) {
    this.userId = userId;
    return this;
  }

  /**
   * The minecraft uuid of a player
   * @return userId
  */
  @ApiModelProperty(value = "The minecraft uuid of a player")

  @Valid

  public UUID getUserId() {
    return userId;
  }

  public void setUserId(UUID userId) {
    this.userId = userId;
  }

  public UserCreationDto email(String email) {
    this.email = email;
    return this;
  }

  /**
   * The email of a user
   * @return email
  */
  @ApiModelProperty(value = "The email of a user")


  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UserCreationDto userCreation = (UserCreationDto) o;
    return Objects.equals(this.userId, userCreation.userId) &&
        Objects.equals(this.email, userCreation.email);
  }

  @Override
  public int hashCode() {
    return Objects.hash(userId, email);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UserCreationDto {\n");
    
    sb.append("    userId: ").append(toIndentedString(userId)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

