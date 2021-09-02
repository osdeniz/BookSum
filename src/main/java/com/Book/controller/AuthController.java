package com.Book.controller;

import com.Book.entity.UserEntity;
import com.Book.model.dto.UserDto;
import com.Book.service.IAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/auth", produces = "application/json")
public class AuthController {

    @Autowired
    private IAuthService authService; //auth serviceyi inject ettik

    @RequestMapping(value = "register", method = RequestMethod.POST)
    public UserEntity register(@RequestBody UserDto userDto){
    return authService.create(userDto);
    }

    @RequestMapping(value = "update", method = RequestMethod.PUT)
    public UserEntity update(@RequestBody UserDto userDto) throws Exception{
    return authService.update(userDto);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public String delete(@PathVariable Long id){
        return authService.removeUser(id);
    }
}
