package com.edge.restapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.edge.restapi.modelo.Customer;

/* Se encarga de  pasar de la persistencia al service (Customer Things)
 * 
*/

@Repository
public interface CustomerRepository extends JpaRepository<Customer, String>{
	//Customer findByName(String nombre);
}
