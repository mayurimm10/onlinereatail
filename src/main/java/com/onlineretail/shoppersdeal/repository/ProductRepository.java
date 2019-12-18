package com.onlineretail.shoppersdeal.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.onlineretail.shoppersdeal.model.Product;
/**
 * 
 * @author Intelliswift.Test1
 *
 */
public interface ProductRepository extends CrudRepository<Product, Integer> {
	public Optional<Product> findById(Integer id);

}
