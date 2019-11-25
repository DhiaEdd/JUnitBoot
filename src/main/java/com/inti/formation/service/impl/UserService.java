package com.inti.formation.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inti.formation.models.User;
import com.inti.formation.repositories.IUserRepository;
import com.inti.formation.service.IUserService;

@Service
public class UserService implements IUserService {

	@Autowired
	private IUserRepository repo;

	@Override
	public User ajoutUser(User user) {
		return repo.save(user);
	}

	@Override
	public User updateUser(User user) {
		return repo.save(user);
	}

	@Override
	public void deleteUser(long id) {
		repo.deleteById(id);
	}

	@Override
	public User getUser(long id) {
		return repo.getOne(id);
	}

	@Override
	public List<User> getAll() {
		System.out.println("Getting users from DB");
		return repo.findAll();
	}

	@Override
	public List<User> getByNom(String nom) {
		// TODO Auto-generated method stub
		return repo.findByNom(nom);
	}

}
