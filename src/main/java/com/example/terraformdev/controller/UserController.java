package com.example.terraformdev.controller;

import com.example.terraformdev.dto.UserDto;
import com.example.terraformdev.mapper.UserMapper;
import com.example.terraformdev.service.UserService;
import lombok.RequiredArgsConstructor;
import model.UserModel;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("{id}")
    UserDto user(@PathVariable String id) {
        UserModel userModel = userService.getUser(id);
        UserDto userDto = UserMapper.MAPPER.convertDto(userModel);
        return userDto;
    }

    @GetMapping("/")
    List<UserDto> users() {
        List<UserModel> userModel = userService.getUsers();
        List<UserDto> userDto = UserMapper.MAPPER.convertDtoList(userModel);
        return userDto;
    }

    @PostMapping
    UserDto save(@RequestBody UserModel userModel) {
        UserModel userModel1 = userService.save(userModel);
        UserDto userDto = UserMapper.MAPPER.convertDto(userModel1);
        return userDto;
    }

    @DeleteMapping("/{id}")
    Void delete(@PathVariable String id) {
        userService.delete(id);
        return null;
    }

    @PutMapping("/{id}")
    UserDto update(@RequestBody UserModel userModel, @PathVariable String id) {
        UserModel userModel1 = userService.update(userModel);
        UserDto userDto = UserMapper.MAPPER.convertDto(userModel1);
        return userDto;
    }
}
    
