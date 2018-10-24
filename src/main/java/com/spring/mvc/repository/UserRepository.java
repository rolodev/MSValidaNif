package com.spring.mvc.repository;

import org.springframework.data.repository.CrudRepository;

import com.spring.mvc.model.User;

public interface UserRepository extends CrudRepository<User, Long> {

}
