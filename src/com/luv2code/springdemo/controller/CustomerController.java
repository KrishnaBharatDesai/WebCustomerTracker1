package com.luv2code.springdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/testIndex")
public class CustomerController {
	
	@RequestMapping("/list")
	public String listCustomers(Model theModel) {
		
		return "list-customers";
	}
}
