package com.luv2code.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.luv2code.springdemo.dao.CustomerDAO;
import com.luv2code.springdemo.entity.Customer;
import com.luv2code.springdemo.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	//injecting the customer DAO
	/*
	 * @Autowired private CustomerDAO customerDAO;
	 */
	
	//injecting service layer
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/list")
	public String listCustomers(Model model) {
		
		/*
		 * //get the customers from the dao
		 *  List<Customer> theCustomers=customerDAO.getCustomers();
		 */
		//get the customers from the service
		List<Customer> theCustomers=customerService.getCustomers();
		
		//add the customers to the model
		model.addAttribute("customerscontrol", theCustomers);
		 
		return "list-customers";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model model)
	{
		
		//create model attribute to bind the form data
		Customer theCustomers= new Customer();
		
		model.addAttribute("customer", theCustomers);
		return "customer-form";
		
	}
	
	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer theCustomer) {
		
		customerService.saveCustomer(theCustomer);
		return "redirect:/customer/list";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormUpdate(@RequestParam("customerId") int theId, Model model) {
		
//		get the customer from database
		Customer theCustomer=customerService.getCustomer(theId);
		
		//set customer as model attribute to pre-populate the form
		model.addAttribute("customer", theCustomer); //to have the same name ofmodel attr as that used in the form of jsp page
		
		//send over to our form
		return "customer-form";
	}
}
