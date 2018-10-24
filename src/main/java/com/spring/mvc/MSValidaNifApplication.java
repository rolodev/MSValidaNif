package com.spring.mvc;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class MSValidaNifApplication  extends SpringBootServletInitializer {

	@Autowired
	DataSource dataSource;

	public static void main(String[] args) {
		SpringApplication.run(MSValidaNifApplication.class, args);
	}
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(MSValidaNifApplication.class);
	}
}
