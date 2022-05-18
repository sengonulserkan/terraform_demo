package com.example.terraformdev.repository;

import model.UserModel;

import org.mapstruct.Mapper;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.MongoRepository;

@Mapper
public interface UserRepository extends MongoRepository<UserModel,String> {

}
