package com.spring.mvc.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.mvc.model.User;
import com.spring.mvc.repository.UserRepository;

@Service("userService")
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;

	public List<User> findAllUsers() throws Exception {
		List<User> list = new ArrayList<>();
		userRepository.findAll().forEach(e -> list.add(e));
		return list;
	}

	public User findById(long id) throws Exception {
		return userRepository.findById(id).get();
	}

	public User findByName(String name) {		
		return null;
	}

	public void saveUser(User user) throws Exception {
		userRepository.save(user);
	}

	public void updateUser(User user) throws Exception {
		userRepository.save(user);		
	}

	public void deleteUserById(long id) throws Exception {
		userRepository.deleteById(id);
	}

	public boolean isUserExist(User user) {
		return findByName(user.getUsername())!=null;
	}	

	public void deleteAllUsers(){
		System.out.println("userRepository.deleteAll() No implementado");
	}

}
