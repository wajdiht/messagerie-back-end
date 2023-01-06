package tn.essat.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Entity
public class Message {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id ;
	private String sujet;
	private String contenu;
	@ManyToOne
	@JoinColumn(name="usersend_id")
	private User usersend;
	@ManyToOne  //kn lista tabda bl one kn objet nabdo bl many
	@JoinColumn(name="userreceive_id")
	private User userreceive;
	public Message(Integer id, String sujet, String contenu, User usersend, User userreceive) {
		super();
		this.id = id;
		this.sujet = sujet;
		this.contenu = contenu;
		this.usersend = usersend;
		this.userreceive = userreceive;
	}
	public Message() {
		super();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getSujet() {
		return sujet;
	}
	public void setSujet(String sujet) {
		this.sujet = sujet;
	}
	public String getContenu() {
		return contenu;
	}
	public void setContenu(String contenu) {
		this.contenu = contenu;
	}
	public User getUsersend() {
		return usersend;
	}
	public void setUsersend(User usersend) {
		this.usersend = usersend;
	}
	public User getUserreceive() {
		return userreceive;
	}
	public void setUserreceive(User userreceive) {
		this.userreceive = userreceive;
	}
	
	

}
