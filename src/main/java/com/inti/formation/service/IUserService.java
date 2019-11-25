package com.inti.formation.service;

import java.util.List;

import com.inti.formation.models.User;

public interface IUserService {
	
	public User ajoutUser(User user); 
	public User updateUser(User user); 
	public void deleteUser(long id); 
	public User getUser(long id); 
	public List<User> getAll(); 
	public List<User> getByNom(String nom); 

}
