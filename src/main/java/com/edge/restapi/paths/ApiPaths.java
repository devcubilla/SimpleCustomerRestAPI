package com.edge.restapi.paths;

public class ApiPaths {
	public static final String HELLO = "/hello";

	private static final String BASE_API = "/api/v1/";
	private static final String CUSTOMER = BASE_API + "customers";
	///////////////////////////////////////////////////////////////////// Customer API's
	//Add a new customer to the database
	public static final String ADD_CUSTOMER = CUSTOMER;
	//View a list of all customers in the database
	public static final String ALL_CUSTOMER = CUSTOMER;
	//Search for a customer by name or ID
	public static final String ABOUT_CUSTOMER = CUSTOMER + "/{customerID}";
	//Update the details of a customer
	public static final String UPDATE_CUSTOMER = CUSTOMER + "/{customerID}";
	//Delete a customer from the database
	public static final String DELETE_CUSTOMER = CUSTOMER + "/{customerID}";

}
