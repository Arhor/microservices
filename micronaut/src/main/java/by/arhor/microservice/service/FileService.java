package by.arhor.microservice.service;

import javax.inject.Singleton;

import java.io.File;

import io.reactivex.Single;

@Singleton
public final class FileService implements Service<File> {

  @Override
  public File doWorkBlock() {
    return null;
  }

  @Override
  public Single<File> doWorkAsync() {
    return null;
  }

}
