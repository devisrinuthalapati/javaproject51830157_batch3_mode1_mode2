package com.bankapp.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bankapp.model.entity.Account;
import com.bankapp.model.entity.Customer;
import com.bankapp.model.entity.Transactions;
import com.bankapp.model.service.AccountService;
import com.bankapp.model.service.TransactionService;
import com.bankapp.web.beanconfig.AccountRequest;

@Controller

public class AccountController {
	@Autowired
	private AccountService accountService;
	@Autowired
	private TransactionService transactionService;
	
	@RequestMapping(value="/allaccounts",method=RequestMethod.GET)
	public String allAccounts(ModelMap map){
		map.addAttribute("account", accountService.findAll());
		return "allaccounts";
		
		
	}
	@RequestMapping(value="/addaccount",method=RequestMethod.GET)
	public String addAccountGet(ModelMap map){
		map.addAttribute("account", new AccountRequest());
		return "addaccount";
		
		
	}
	@RequestMapping(value="/addaccount",method=RequestMethod.POST)
	public String addAccountPost(@ModelAttribute(name="account")AccountRequest accountRequest,BindingResult bindingResult){
		if(bindingResult.hasErrors()){
			return "addaccount";
			}
		else{
			if(accountRequest.getAccountNumber()==0){
				Account account=new Account(accountRequest.getBalance(), false);
				Customer customer=new Customer(accountRequest.getName(), accountRequest.getEmail(),  accountRequest.getPhone(),  accountRequest.getAddress(),  accountRequest.getCity(),  accountRequest.getCountry());
				account.setCustomer(customer);
				accountService.createAccount(account);
			}
			/*else{
				accountService.updateAccount(accountRequest, accountRequest.getAccountNumber());
			}*/
		}
		
		return "redirect:allaccounts";
		
		
	}
	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public String deleteCustomer(HttpServletRequest req) {
		Long accnumber = Long.parseLong(req.getParameter("accountNumber"));
		accountService.deleteAccount(accnumber);
		return "redirect:allcustomer";
	}
	/*@RequestMapping(value="update",method= RequestMethod.GET)
	public String updateGet(HttpServletRequest req){
		Long accnumber = Long.parseLong(req.getParameter("accountNumber"));
		Account account=new 
		accountService.updateAccount(req., accnumber);
	}*/
}
