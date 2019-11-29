package com.bankapp.web;

import java.security.Principal;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bankapp.model.service.AccountService;
import com.bankapp.web.beanconfig.AccountRequest;
import com.bankapp.web.beanconfig.TransferRequest;
import com.bankapp.web.beanconfig.WithdrawOrDepositRequest;

@Controller
@RequestMapping(path="api")
public class TransactionController {
	@Autowired
	private AccountService accountService;
	
	
	
	@RequestMapping(value = "transfer", method = RequestMethod.GET)
	public String transferGet(Model model) {
	model.addAttribute("transferform", new TransferRequest());
	return "transfer";

	}


	@RequestMapping(value = "withdraw", method = RequestMethod.GET)
	public String withdrawGet(Model model) {
	model.addAttribute("formbean", new WithdrawOrDepositRequest());
	return "deposit";

	}

	@RequestMapping(value = "withdraw", method = RequestMethod.POST)
	public String withdrawPost(
	@Valid @ModelAttribute(value = "formbean") WithdrawOrDepositRequest formbean,
	BindingResult bindingResult,Principal principal) {
	if (bindingResult.hasErrors()) {
	return "withdraw";
	}
	accountService.withdraw(formbean.getAccountNumber(),formbean.getAmount(),principal.getName());

	return "redirect:allaccounts";
	}


	@RequestMapping(value = "deposit", method = RequestMethod.GET)
	public String depositGet(Model model) {
	model.addAttribute("formbean", new WithdrawOrDepositRequest());
	return "deposit";

	}

	@RequestMapping(value = "deposit", method = RequestMethod.POST)
	public String depositPost(
	 @ModelAttribute(value = "formbean") WithdrawOrDepositRequest formbean,
	BindingResult bindingResult,Principal principal) {
	if (bindingResult.hasErrors()) {
	return "deposit";
	}
	accountService.deposit(formbean.getAccountNumber(),formbean.getAmount(),principal.getName());

	return "redirect:allaccounts";
	}

	@RequestMapping(value = "transfer", method = RequestMethod.POST)
	public String transferPost(
	 @ModelAttribute(value = "transferform") TransferRequest transferform,
	BindingResult bindingResult,Principal principal) {
	if (bindingResult.hasErrors()) {
	return "transfer";
	}
	accountService.transfer(transferform.getFromAccount(),
			transferform.getToAccount(),transferform.getAmount(),principal.getName());
	return "redirect:allaccounts";

	}

}
