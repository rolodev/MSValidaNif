package com.spring.mvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.mvc.model.ValidaNif;
import com.spring.mvc.repository.MSValidaNifRepository;

@Service("userService")
public class MSValidaNifServiceImpl implements MSValidaNifService{

	@Autowired
	private MSValidaNifRepository validanifRepository;


	public void altaValidacion(ValidaNif validanif) throws Exception {
		validanifRepository.save(validanif);
	}

}
