package com.inti.formation;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.inti.formation.models.User;
import com.inti.formation.repositories.IUserRepository;
import com.inti.formation.service.impl.UserService;

//sert à établir un pont entre les fonctionnalités de test Spring Boot et JUnit.
@RunWith(SpringRunner.class)
@SpringBootTest


public class UserServiceTest {

	@Autowired
	private UserService service;

	@MockBean
	private IUserRepository repository;

	@Test
	public void getUsersTest() {
		when(repository.findAll()).thenReturn(Stream
				.of(new User(1, "ELADIB", "DhiaEddine"), new User(2, "Ahmed", "Ahmed"), new User(3, "Badr", "Badr"))
				.collect(Collectors.toList()));

		assertEquals(3, service.getAll().size());

	}
	
	@Test
	public void getUsersByNomTest() {
		String nom="ELADIB";
		when(repository.findByNom(nom)).thenReturn(Stream
				.of(new User(1, "ELADIB", "DhiaEddine"))
				.collect(Collectors.toList()));
		assertEquals(1, service.getByNom("ELADIB").size());
		
	}
	
	@Test
	public void saveUserTest() {
		
		User user= new User(9999, "saveUser", "saveUser");
		when(repository.save(user)).thenReturn(user);
		assertEquals(user, service.ajoutUser(user));
		
	}
	
	@Test
	public void updateUserTest() {
		
		User user= new User(9999, "saveUs", "saveUser");
		when(repository.save(user)).thenReturn(user);
		assertEquals(user, service.updateUser(user));
		
	}
	
	@Test
	public void deleteUserTest() {
		
		User user= new User(9999, "saveUser", "saveUser");
		service.deleteUser(user.getId());
		verify(repository,times(1)).deleteById(user.getId());;
		
	}
	
}
