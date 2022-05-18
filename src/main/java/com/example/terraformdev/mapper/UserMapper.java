package com.example.terraformdev.mapper;

import com.example.terraformdev.dto.UserDto;
import model.UserModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import javax.xml.transform.Source;
import java.lang.annotation.Target;
import java.util.List;
import java.util.Optional;

@Mapper
public interface UserMapper {

    UserMapper MAPPER = Mappers.getMapper( UserMapper.class );

    @Mapping( source = "id", target = "t_id" )
    UserDto convertDto (UserModel userModel);
}
