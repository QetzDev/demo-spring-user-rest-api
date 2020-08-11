package de.qetz.restuser;

import lombok.Data;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RestuserApplication {
  public static void main(String[] args) {
    SpringApplication.run(RestuserApplication.class, args);
  }
}
