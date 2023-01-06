package tn.essat.rest;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.essat.Model.Message;
import tn.essat.Model.User;
import tn.essat.dao.IMesssage;
import tn.essat.dao.IUser;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest")
public class AppRestMessage {

	
	@Autowired
	IMesssage messagedao;
	
	@Autowired
	IUser userdao;
	@GetMapping("/messagesrecus/{id}")
	public List<Message> get1(@PathVariable int id){
		return messagedao.getAllMessageReceives(id);
	}
	@GetMapping("/messagesenvoyes/{id}")
	public List<Message> get2(@PathVariable int id){
		return messagedao.getAllMessageSend(id);
	}
	@DeleteMapping("/deletemessage/{id}")
	public void del(@PathVariable int id){
		messagedao.deleteById(id);
	}
	@PostMapping("/savemessage")
	public void post2222(@RequestBody Message m){
	messagedao.save(m);
	}
	@GetMapping("/getUsers/{username}")
	public User f22(@PathVariable("username") String username) {
		return userdao.findByUsername(username);
	}
	@GetMapping("/getAllusers")
	public List<User>  f23() {
		return userdao.findAll();
	
}}
