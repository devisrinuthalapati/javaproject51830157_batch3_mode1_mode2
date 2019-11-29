package com.bankapp.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bankapp.model.entity.TransactionLog;
import com.bankapp.model.entity.User;
import com.bankapp.model.service.TransactionalLogService;
import com.bankapp.model.service.UserService;

@Controller
@RequestMapping(path="api")
public class UserController {
	/*@GetMapping(path="/admin")
	public String admin(){
		return "hello to admin";
	}
	@GetMapping(path="/mgr")
	public String mgr(){
		return "hello to mgr";
	}
	@GetMapping(path="/clerk")
	public String clerk(){
		return "hello to clerk";
	}*/
	@Autowired
	private UserService userService;
	
	@Autowired
	private TransactionalLogService transactionLogService;
	@GetMapping(path="/allusers")
	public String allusers(ModelMap map){
		map.addAttribute("users", userService.findAll());
		return "allusers";
	}
	@GetMapping(path="/newuser")
	public String addNewUser(ModelMap map){
		
		map.addAttribute("user" ,new User());
		return "adduser";
		}
	
	
	@PostMapping(path="/newuser")
	public String addNewUserPost(@ModelAttribute(name="user")User user,BindingResult bindingResult){
		if(bindingResult.hasErrors()){
			return "adduser";
		}else{
			userService.addUser(user);
		}
		return "redirect:allusers";
	}
	@GetMapping(path="/deleteuser")
	public String deleteUser(HttpServletRequest req){
		Long userToBeDelete=Long.parseLong(req.getParameter("id"));
		userService.deleteUser(userToBeDelete);
		return "redirect:allusers";
	}
	

}
