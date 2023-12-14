package com.apirestmongo.persistenciayseguridadapirest.domain.repository;

import com.apirestmongo.persistenciayseguridadapirest.domain.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {


}
