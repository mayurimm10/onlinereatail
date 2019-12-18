package com.onlineretail.shoppersdeal.service;

import java.util.List;

import com.onlineretail.shoppersdeal.model.Bill;
import com.onlineretail.shoppersdeal.model.Product;

/**
 * 
 * @author Intelliswift.Test1
 *
 */
public interface BillService {
	public Bill generateBill(List<Product> product);

}
