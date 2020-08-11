package de.qetz.restuser;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RestuserApplication {
  private static RestuserApi api;

  public static void main(String[] args) {
    BeanFactory factory = SpringApplication.run(RestuserApplication.class, args);
    api = factory.getBean(RestuserApi.class);
  }

  public static RestuserApi api() {
    return api;
  }
}
