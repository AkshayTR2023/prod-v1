package com.example.demo;

import java.text.ParseException;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdDAO {
	@Autowired
	ProdRepo prodRepo;
	public Product getProd(int ID) {
		return prodRepo.getProdByID(ID);
	}
	public Product addProd(Product product) {
		Logger log = Logger.getAnonymousLogger();
		log.info(product.toString());
		return prodRepo.save(product);
	}
	
	public List<Product> getAllProd(){
		return prodRepo.findAll();
	}
	
	
	public void delProd(int ID) {
		prodRepo.deleteById(ID);
	}
	
	public Product editProd(Product product) throws ParseException {
		return prodRepo.save(product);
	}
}
