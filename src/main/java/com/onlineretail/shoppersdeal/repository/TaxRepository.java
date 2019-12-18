package com.onlineretail.shoppersdeal.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.onlineretail.shoppersdeal.model.SalesTax;

/**
 * 
 * @author Intelliswift.Test1
 *
 */
@Repository
public interface TaxRepository extends CrudRepository<SalesTax, Integer> {

}
