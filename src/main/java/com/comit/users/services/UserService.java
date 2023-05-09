package com.comit.users.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.comit.users.bean.UserBean;
import com.comit.users.dao.UserDao;

@Service
public class UserService {
	
	@Autowired
	UserDao userDao;
	
	public List<UserBean> listUsers() {
		
		List<UserBean> users = this.userDao.listUsers();
		
		return users;
		
	}
    
	public void createUser(UserBean user) {
		
		this.validateUser(user);
		
		this.userDao.createUser(user);
		
	}
	
	public UserBean fineUser(int idUSer) {
		
		return this.userDao.fineUser(idUSer);
		
	}
   public void updateUser(UserBean user) {
		
		this.validateUser(user);
		
		this.userDao.updateUser(user);
		
	}
   
   public void deleteUser(int idUser) {
	   this.userDao.deleteUser(idUser);
	   
   }
	
    private void validateUser(UserBean user) {
		
		if (user.getFirstName().isEmpty() ||
			user.getLastName().isEmpty()||
			user.getUsername().isEmpty()) {
			throw new RuntimeException("Invalid User Data:" + user);
		}
		
	}
}
