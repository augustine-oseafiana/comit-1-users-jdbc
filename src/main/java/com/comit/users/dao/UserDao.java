package com.comit.users.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.comit.users.bean.UserBean;
import com.comit.users.util.util;

@Repository
public class UserDao {
	
	List<UserBean> users;
	
	public UserDao() {
		this.users = new ArrayList<UserBean>();
	
		users.add(new UserBean(1,"John","Doe","jdoe","123",util.parseDate("1992-02-04"),"A"));
		users.add(new UserBean(2,"Jane","Smile","jsmile","123",util.parseDate("1992-07-04"),"A"));
		users.add(new UserBean(3,"Pete","Mark","pmark","123",util.parseDate("1984-02-04"),"A")); 
    }
		
	public List<UserBean> listUsers() {	
		
		return this.users;
	}
	
	public synchronized void createUser(UserBean user) {
		
		  int max =	this.users.stream()
			                .mapToInt(u->u.getIdUser())
			                .max().orElse(0);
		
		  user.setIdUser(++max);
		  user.setStatus("A");
		  this.users.add(user);
			
		}
	
   public UserBean fineUser(int idUser) {
		
		return this.users.stream()
				       .filter(u->u.getIdUser()==idUser)
				       .findAny().orElse(null);
		
	}
   
   public void updateUser(UserBean user) {
	
	UserBean currentUser = this.fineUser(user.getIdUser());
	
	if (currentUser!= null) {
		currentUser.setFirstName(user.getFirstName());
		currentUser.setLastName(user.getLastName());
		currentUser.setUsername(user.getUsername());
		currentUser.setBirth(user.getBirth());
		
	}
	
   }
   public void deleteUser(int idUser) {
	
	this.users.removeIf(u->u.getIdUser()==idUser);
	
}
}
