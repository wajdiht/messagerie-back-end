package tn.essat.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.essat.Model.User;

public interface IUser extends JpaRepository<User, Integer>{
	public User findByUsername(String username);

}
