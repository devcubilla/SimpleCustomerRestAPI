package com.edge.restapi.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import com.edge.restapi.excepciones.CustomerException;
import com.edge.restapi.excepciones.CustomerNotFoundException;
import com.edge.restapi.modelo.Customer;
import com.edge.restapi.paths.ApiPaths;
import com.edge.restapi.service.CustomerService;

@RestController  //Usa la config basica de @Controller y otro.
public class CustomerController {
	private CustomerService customerService;
	

	@Autowired 
	public void jugadorService(CustomerService customerService) {
	
		this.customerService = customerService;
	
	}
	
	@GetMapping(ApiPaths.HELLO)
	public String helloWorld() {		
		return customerService.helloWorld();
	}
	
	////////////////////////////////////////////////////////////////////////////////// POST METODO Add a new customer to the database
	@RequestMapping(path = ApiPaths.ADD_CUSTOMER, method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Customer addCustomer(@RequestBody Customer addThisCustomer) throws CustomerException{
		return customerService.addCustomer(addThisCustomer);
	}
////////////////////////////////////////////////////////////////////////////////// View a list of all customers in the database
	@RequestMapping(path = ApiPaths.ALL_CUSTOMER, method = RequestMethod.GET)
	public List<Customer> getAllCustomer() throws CustomerException {
		return customerService.getAllCustomer();
	}
	
////////////////////////////////////////////////////////////////////////////////// Search for a customer by name or ID
	@RequestMapping(path = ApiPaths.ABOUT_CUSTOMER , method = RequestMethod.GET)
	public Customer getCustomerID(@PathVariable(name = "customerID")long customerID) throws CustomerNotFoundException {
		return customerService.getCustomerID(customerID);
	}
	
////////////////////////////////////////////////////////////////////////////////// Update the details of a customer
	
	@RequestMapping(path = ApiPaths.UPDATE_CUSTOMER ,method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Customer updateCustomer(@RequestBody Customer customerToUpdate, @PathVariable(name = "customerID")long customerID) throws CustomerException {
		return customerService.updateCustomer(customerID, customerToUpdate);
	}
	
////////////////////////////////////////////////////////////////////////////////// Delete a customer from the database
	@RequestMapping(path = ApiPaths.DELETE_CUSTOMER , method = RequestMethod.DELETE)
	public HttpStatus deleteCustomerByID(@PathVariable(name = "customerID")long customerID) throws CustomerException {
		return customerService.deleteCustomerByID(customerID);
	}
}
