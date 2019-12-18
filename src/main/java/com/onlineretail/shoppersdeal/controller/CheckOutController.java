package com.onlineretail.shoppersdeal.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onlineretail.shoppersdeal.model.Bill;
import com.onlineretail.shoppersdeal.model.Product;
import com.onlineretail.shoppersdeal.repository.ProductRepository;
import com.onlineretail.shoppersdeal.service.BillService;

/**
 * 
 * @author Intelliswift.Test1
 *
 */
@RestController
@RequestMapping("/checkout")
public class CheckOutController {
	Logger log = LoggerFactory.getLogger(CheckOutController.class);
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private BillService billService;

	/**
	 * Generates the bill for the products listed in the cart.
	 * 
	 * @return itemized bill along with the totalcost and totalsales tax of all the products 
	 */
	@GetMapping(value = "/generateBill")
	private Bill generateBill() {
		Iterable<Product> products = productRepository.findAll();
		List<Product> cartItems = new ArrayList<Product>();

		for (Product items : products) {
			cartItems.add(items);
		}
		System.out.println("In controller " + cartItems.toString());
		Bill generatedBill = billService.generateBill(cartItems);
		return generatedBill;
	}
}
