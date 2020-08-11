package de.qetz.restuser;

import org.junit.Before;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class RestuserApplicationTests {
  private RestuserApi api;

  @Before
  public void startApplication() {
    RestuserApplication.main(new String[]{});
    this.api = RestuserApplication.api();
  }
}
