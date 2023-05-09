package com.comit.users.bean;

import java.util.Date;

public class UserBean {
	
	int idUser;
	String firstName;
	String lastName;
	String username;
	String password;
	Date birth;
	String status;
	public UserBean(int idUser, String firstName, String lastName, String username, String password, Date birth,
			String status) {
		super();
		this.idUser = idUser;
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		this.birth = birth;
		this.status = status;
	}
	public int getIdUser() {
		return idUser;
	}
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getBirth() {
		return birth;
	}
	public void setBirth(Date birth) {
		this.birth = birth;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "UserBean [idUser=" + idUser + ", firstName=" + firstName + ", lastName=" + lastName + ", username="
				+ username + ", password=" + password + ", birth=" + birth + ", status=" + status + "]";
	}
	
	
	

}
