package com.example.p2ptraderest.controller;

import com.example.p2ptraderest.entity.UsersEntity;
import com.example.p2ptraderest.service.UsersService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
public class UserController {

    UsersEntity user = new UsersEntity();
    UsersService usersService;

    public UserController(UsersService usersService) {
        this.usersService = usersService;
    }

    @RequestMapping(value="/user", method = RequestMethod.GET)
    public ResponseEntity<Object> getUser(){
        return new ResponseEntity<>(usersService.getAllUsers(), HttpStatus.OK);
    }

    @RequestMapping(value="/allUsers", method = RequestMethod.GET)
    public ResponseEntity<Object> getAllUser(){
        return new ResponseEntity<>(usersService.getAllUsers(), HttpStatus.OK);
    }

    @RequestMapping(value="/create-user", method = RequestMethod.POST)
    public ResponseEntity<Object> createUser(@RequestBody UsersEntity user){
        usersService.createUser(user);
        return new ResponseEntity<>("Created user "+ user.getName(), HttpStatus.OK);
    }

    @RequestMapping(value="/delete-user/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteUser(@PathVariable("id") Long id){
        List<UsersEntity> allUsers = usersService.getAllUsers();
        for(UsersEntity userToDelete : allUsers){
            if(userToDelete.getId() == id){
                user = userToDelete;
            }
        }
        usersService.deleteUser(user);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
