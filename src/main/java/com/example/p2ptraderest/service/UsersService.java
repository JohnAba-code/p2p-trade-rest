package com.example.p2ptraderest.service;

import com.example.p2ptraderest.entity.UsersEntity;
import com.example.p2ptraderest.repository.UsersRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersService {

    UsersRepository usersRepository;

    public UsersService (UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public List<UsersEntity> getFirstByName(String name) {
       return usersRepository.findFirstByName(name);
    }

    public UsersEntity createUser(UsersEntity user) {
        return usersRepository.save(user);
    }

    public UsersEntity updateUser(UsersEntity user) {
        return usersRepository.save(user);
    }

    public void deleteUser(UsersEntity user) {
        usersRepository.delete(user);
    }

    public List<UsersEntity> getAllUsers() {
        return usersRepository.findAll();
    }
}
