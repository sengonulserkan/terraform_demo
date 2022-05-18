package com.example.terraformdev.dto;

import lombok.Data;
import java.util.Date;

public class UserDto {
    private String t_id;
    private String name;
    private int age;

    public UserDto(String t_id, String name, int age) {
        this.t_id = t_id;
        this.name = name;
        this.age = age;
    }

    public UserDto() {
    }

    public String getT_id() {
        return t_id;
    }

    public void setT_id(String t_id) {
        this.t_id = t_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
