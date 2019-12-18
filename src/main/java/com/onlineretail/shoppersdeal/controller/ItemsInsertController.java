package com.onlineretail.shoppersdeal.controller;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.onlineretail.shoppersdeal.model.Categories;
import com.onlineretail.shoppersdeal.model.Product;
import com.onlineretail.shoppersdeal.repository.CategoriesRepository;
import com.onlineretail.shoppersdeal.repository.ProductRepository;

/**
 * 
 * @author Intelliswift.Test1
 *
 */
@RestController
@RequestMapping("/insert")
public class ItemsInsertController {
	Logger log = LoggerFactory.getLogger(ItemsInsertController.class);

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private CategoriesRepository categoriesRepository;
	
	/**
	 * Inserts the item into the cart using following parameters.
	 * @param name  Name of the product added to cart
	 * @param price  price of the product added to cart
	 * @param category the category to which the product belongs
	 * @param quantity the ordered quantity of the product
	 * @return
	 */

	@PostMapping(value = "/product")
	public String insertToCart(@RequestParam("name") String name, @RequestParam("price") Double price,
			@RequestParam("category") String category, @RequestParam("quantity") Integer quantity) {

		Product product = new Product();

		log.info("name " + name);
		log.info("price " + price);
		log.info("category " + category);
		log.info("quantity " + quantity);

		product.setProduct_name(name);
		product.setProduct_price(price);
		product.setQuantity(quantity);
		if (category.equalsIgnoreCase("A")) {

			Optional<Categories> categories = categoriesRepository.findById(1);
			if (categories.isPresent()) {
				product.setCategories(categories.get());
			}
			log.info("Category id fetched " + product.getCategories().getCategory_id());
			log.info("levy fetched " + product.getCategories().getSalesTax().getLevy());
		}

		else if (category.equalsIgnoreCase("B")) {

			Optional<Categories> categories = categoriesRepository.findById(2);
			if (categories.isPresent()) {
				product.setCategories(categories.get());
			}
			log.info("Category id fetched " + product.getCategories().getCategory_id());
			log.info("levy fetched " + product.getCategories().getSalesTax().getLevy());
		}

		else {

			Optional<Categories> categories = categoriesRepository.findById(3);
			if (categories.isPresent()) {
				product.setCategories(categories.get());
			}
			log.info("Category id fetched " + product.getCategories().getCategory_id());
			log.info("levy fetched " + product.getCategories().getSalesTax().getLevy());
		}

		productRepository.save(product);
		return "Item added to cart successfully";
	}

}
