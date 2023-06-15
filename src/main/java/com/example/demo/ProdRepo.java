package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProdRepo extends JpaRepository<Product, Integer> {

	@Query("SELECT p FROM Product p WHERE p.prodID = ?1")
	public Product getProdByID(int ID);

}
