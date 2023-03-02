package com.edge.restapi.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.edge.restapi.excepciones.CustomerException;
import com.edge.restapi.excepciones.CustomerNotFoundException;
import com.edge.restapi.modelo.Customer;
import com.edge.restapi.paths.Contacto;
import com.edge.restapi.repository.CustomerRepository;

@Service
public class CustomerService {
	private Logger logg = LoggerFactory.getLogger(CustomerService.class);
	private CustomerRepository customerRepository;

	@Autowired
	public void customerRepository(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}

	public Customer addCustomer(Customer customer) throws CustomerException {
		try {
			authWatcher();
			logg.info("Saving Customer..." + customer.toString());
			Customer addThisCustomer = customerRepository.save(customer);
			return addThisCustomer;
		}catch(Exception e) {
			logg.error("An error ocurre during Customer saving.." + e.getMessage());
			throw new CustomerException("[Error-Persona-Save] Contactar: "+  Contacto.ADMIN);
		}
	}

	public List<Customer> getAllCustomer() throws CustomerException {
		try {
			authWatcher();
			logg.info("Getting all Customer");
			List<Customer> lista = customerRepository.findAll();
			return lista;
		} catch (Exception e) {
			logg.error("ErrorGetting All Customer " + e.getMessage() + e.getStackTrace());
			throw new CustomerException("[Error-Get-Customer] Contactar: "+  Contacto.ADMIN);

		}
	}

	public Customer getCustomerID(long customerID) throws CustomerNotFoundException{
		try {
			authWatcher();
			logg.info("Getting Customer By ID");
			Optional<Customer> optfoundCustomer = customerRepository.findById(String.valueOf(customerID));
			Customer foundCustomer = optfoundCustomer.get();
			logg.info("--" + foundCustomer.toString());
			return foundCustomer;
		} catch (Exception e) {
			logg.error("ErrorGetting Customer By ID" + e.getMessage() + e.getStackTrace());
			throw new CustomerNotFoundException(customerID);
		}
	}

	public Customer updateCustomer(long customerID, Customer customerToUpdate) throws CustomerException {
		try {
			authWatcher();
			logg.info("Update Customer By ID: "+ customerID);
			Customer foundCustomer = customerRepository.getReferenceById(String.valueOf(customerID));
			logg.info("Antes --> " + foundCustomer.toString());
			foundCustomer.setNombre(customerToUpdate.getNombre());
			foundCustomer.setApellido(customerToUpdate.getApellido());
			foundCustomer.setCedulaIdentidad(customerToUpdate.getCedulaIdentidad());
			foundCustomer.setEdad(customerToUpdate.getEdad());
			foundCustomer.setEmail(customerToUpdate.getEmail());
			logg.info("Despues --> " + foundCustomer.toString());
			return customerRepository.save(foundCustomer);
		}catch (Exception e) {
			logg.error("An error ocurre during Customer update " + e.getMessage());
			throw new CustomerException("[Error-Customer-Update] Contactar: "+  Contacto.ADMIN);
		}
	}

	public HttpStatus deleteCustomerByID(long customerID) throws CustomerException {
		try {
			authWatcher();
			logg.info("Delete Customer By ID: "+ customerID);
			customerRepository.deleteById(String.valueOf(customerID));
			return HttpStatus.OK;
		}catch (Exception e) {
			logg.error("An error ocurre during Customer delete..." + e.getMessage());
			throw new CustomerException("[Error-Customer-Delete] Contactar: "+  Contacto.ADMIN);
		}
	}

	public String helloWorld() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		logg.info("Datos del user: " + auth.getPrincipal());
		logg.info("Datos de los Permisoss: " + auth.getAuthorities());
		logg.info("Esta autenticado: " + auth.isAuthenticated());
		return "<h1>Hello "+auth.getName().toUpperCase() +"!!</h1>";
	}
		
	public void authWatcher() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		logg.info("Datos del user: " + auth.getPrincipal());
		logg.info("Datos de los Permisoss: " + auth.getAuthorities());
		logg.info("Esta autenticado: " + auth.isAuthenticated());
	}
}
