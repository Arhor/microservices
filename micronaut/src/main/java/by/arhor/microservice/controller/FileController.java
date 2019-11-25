package by.arhor.microservice.controller;

import javax.inject.Inject;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import by.arhor.microservice.service.Service;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.reactivex.Single;

@Controller("/files")
public final class FileController {

  private final Service<File> service;

  @Inject
  public FileController(Service<File> service) {
    this.service = service;
  }

  @Get(uri = "/block", processes = MediaType.TEXT_PLAIN)
  public String readFileBlock() {
    final var content = new StringBuilder();

    try (var scan = new Scanner(service.doWorkBlock())) {
      while (scan.hasNextLine()) {
        content.append(scan.nextLine());
      }
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }

    return content.toString();
  }

  @Get(uri = "/async", processes = MediaType.TEXT_PLAIN)
  public Single<String> sayHelloAsync(String name) {
    return Single.fromCallable(() -> "Hello, " + name);
  }

}
