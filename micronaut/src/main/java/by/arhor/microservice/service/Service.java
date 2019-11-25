package by.arhor.microservice.service;

import io.reactivex.Single;

public interface Service<T> {

  T doWorkBlock();

  Single<T> doWorkAsync();

}
