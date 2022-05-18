package com.example.terraformdev.service;

import com.example.terraformdev.dto.UserDto;
import com.example.terraformdev.mapper.UserMapper;
import com.example.terraformdev.repository.UserRepository;
import jdk.nashorn.internal.runtime.ErrorManager;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import model.UserModel;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
@Slf4j
public class UserService {
    private final UserRepository userRepository;
    public UserModel getUser(String id) {
        Optional<UserModel> optionalUserModel = userRepository.findById(id);
        if(optionalUserModel.isPresent()){
            return optionalUserModel.get();
        }
        return null;
    }

    public List<UserModel> getUsers() {
        List<UserModel> modelList = userRepository.findAll();
        return modelList;
    }

    public UserModel save(UserModel userModel){
        UserModel model = userRepository.save(userModel);
        return model;
    }

    public void delete(String id){
        userRepository.deleteById(id);
    }

    public UserModel update(UserModel userModel){
        Optional<UserModel> storedUserModelOptional = userRepository.findById(userModel.getId());
        try{
            if(storedUserModelOptional.isPresent()){
                UserModel currentModel = storedUserModelOptional.get();
                userModel.setCreatedAt(currentModel.getCreatedAt());
                userModel.setUpdateAt(Date.from(Instant.now()));
                return userRepository.save(userModel);
            }
        } catch (Exception ex){
            log.info("User not found");
        }
        return null;
    }
}
