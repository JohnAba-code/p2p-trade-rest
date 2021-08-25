package com.example.p2ptraderest.repository;

import com.example.p2ptraderest.entity.UsersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsersRepository extends JpaRepository<UsersEntity, Long> {

    List<UsersEntity> findFirstByName(String name);
}
