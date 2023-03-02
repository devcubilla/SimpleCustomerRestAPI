package com.edge.restapi.paths;

public class ApiPaths {

	private static final String BASE_API = "/api/v1/";
	private static final String CUSTOMER = BASE_API + "customer/";
	///////////////////////////////////////////////////////////////////// Customer API's
	//Add a new customer to the database
	public static final String ADD_CUSTOMER = CUSTOMER + "add/";
	//View a list of all customers in the database
	public static final String ALL_CUSTOMER = CUSTOMER + "all/";
	//Search for a customer by name or ID
	public static final String ABOUT_CUSTOMERID = CUSTOMER + "{customerID}";
	//public static final String ABOUT_CUSTOMER_NAME = CUSTOMER + "{name}";
	//Update the details of a customer
	public static final String UPDATE_CUSTOMER = CUSTOMER + "update/{customerID}";
	//Delete a customer from the database
	public static final String DELETE_CUSTOMER = CUSTOMER + "delete/{customerID}";

}
