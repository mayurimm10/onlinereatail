package com.onlineretail.shoppersdeal.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.onlineretail.shoppersdeal.model.Bill;

/**
 * 
 * @author Intelliswift.Test1
 *
 */
@Repository
public interface BillRepository extends CrudRepository<Bill, Integer> {

}
