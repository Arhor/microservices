package by.arhor.microservice.controller;

import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.QueryValue;
import io.reactivex.Single;

@Controller("/greetings")
public final class GreetingController {

  @Get(uri = "/block", processes = MediaType.TEXT_PLAIN)
  public String sayHelloBlock(@QueryValue String name) {
    return "Hello, " + name;
  }

  @Get(uri = "/async", processes = MediaType.TEXT_PLAIN)
  public Single<String> sayHelloAsync(@QueryValue String name) {
    return Single.fromCallable(() -> "Hello, " + name);
  }

}
