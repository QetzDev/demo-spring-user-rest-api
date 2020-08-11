package de.qetz.restuser.user;

import lombok.*;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "user")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public final class User {
  @Id
  @Column(unique = true, updatable = false, nullable = false)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @Type(type = "uuid-char")
  @Column(unique = true, nullable = false, name = "user_id", updatable = false, length = 36)
  private UUID userId;

  @Column
  private String email;
}
