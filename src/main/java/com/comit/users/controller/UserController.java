package com.comit.users.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.comit.users.bean.UserBean;
import com.comit.users.services.UserService;
import com.comit.users.util.util;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class UserController {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	UserService userService;
	
	@GetMapping("/")
	public String index( ) {
		logger.debug("Landing Page");
		return "index";
		
	}
	 @GetMapping("/list")
	 public ModelAndView list() {
		 logger.debug("Listing Users");
		 
		 List<UserBean> users = this.userService.listUsers();
		 
		return new ModelAndView ("list", "users",users);
		
	}
     @GetMapping("/create")
	 public String showcreate() {
		 logger.debug("Show Create");
		 
		 return "create";
		 
	 }
     
     @PostMapping("/create")
	 public String createUser(HttpServletRequest req) {
    	 logger.debug("create User");
    	 
    	 String first = req.getParameter("first");
		 String last = req.getParameter("last");
		 String username = req.getParameter("username");
		 String password = req.getParameter("password");
		 String birth = req.getParameter("birth");
		 
		 UserBean user = this.createUserBean(null, first, last, username, password, birth); 
		 
    	 this.userService.createUser(user);
		 
		 return "redirect:/list";
		 
	 }
     
     @GetMapping("/update/{id}")
     public ModelAndView showUpdate(@PathVariable int id) {
		 logger.debug("Show Update");
		 
		UserBean user = this.userService.fineUser(id);
		
		 return new ModelAndView("Update","user",user);
	 }

     @PostMapping("/update")
     public String updateUser(HttpServletRequest req) {
	 logger.debug("Update User");
	 
	 String id = req.getParameter("id");
	 String first = req.getParameter("first");
	 String last = req.getParameter("last");
	 String username = req.getParameter("username");
	 String birth = req.getParameter("birth");
	 
	 UserBean user = this.createUserBean(id, first, last, username, null , birth);
	 
	 this.userService.updateUser(user);
	 
	 return "redirect:/list";
	 
    }
     
     @GetMapping("/delete/{id}")
	 public String deleteUser(@PathVariable int id) {
    	 this.userService.deleteUser(id);
    	 
    	 return "redirect:/list";
    	 
		 
	 }
     
     private UserBean createUserBean(String id, String first, String last, String username, String password, String birth) {
		 
		 UserBean user = new UserBean(util.parseId(id),first,last,username,password,util.parseDate(birth),"");
		 
		 return user;
		 
	 }
}
