package com.inti.formation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.inti.formation.models.User;
import com.inti.formation.service.IUserService;

@SpringBootApplication
public class JUnitBootApplication implements CommandLineRunner {
//	@Autowired
//    private IUserService service;
	public static void main(String[] args) {
		SpringApplication.run(JUnitBootApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		User u = new User(1, "ELADIB", "DhiaEddine");
		User u1 = new User(2, "Ahmed", "Ahmed");
		User u2 = new User(3, "Badr", "Badr");
//		System.out.println(service.getAll());
		
		
	}

}
