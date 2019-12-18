package com.onlineretail.shoppersdeal.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlineretail.shoppersdeal.model.Bill;
import com.onlineretail.shoppersdeal.model.Order;
import com.onlineretail.shoppersdeal.model.Product;
import com.onlineretail.shoppersdeal.repository.BillRepository;
import com.onlineretail.shoppersdeal.repository.OrderRepository;

/**
 * 
 * @author Intelliswift.Test1
 *
 */
@Service
public class BillServiceImpl implements BillService {
	Logger log = LoggerFactory.getLogger(BillServiceImpl.class);

	@Autowired
	BillRepository billRepository;
	@Autowired
	OrderRepository orderRepository;

	@Override
	/**
	 * accepts the list of products which are added to the cart.
	 * itemazied bill calculations are done.
	 */
	public Bill generateBill(List<Product> product) {
		List<Bill> totalcostandtax = new ArrayList<Bill>();
		List<Order> orderdetails = new ArrayList<Order>();
		Bill bill = new Bill();

		double totalsalestax = 0, totalprice = 0, totalAmountPerItem = 0, totalSalesTaxPerItem;
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date date = new Date();

		for (Product productCost : product) {

			Order order = new Order();
			System.out.println();
			log.info("item in service " + "name " + productCost.getProduct_name() + "price: "
					+ productCost.getProduct_price() + " cat type " + productCost.getCategories().getCategory_type()
					+ " tax applicable: " + productCost.getCategories().getSalesTax().getLevy() + " qty "
					+ productCost.getQuantity());

			order.setProductid(productCost.getId());
			order.setProductName(productCost.getProduct_name());
			order.setQuantity(productCost.getQuantity());
			order.setTax_applied(productCost.getCategories().getSalesTax().getLevy());
			order.setUnitPrice(productCost.getProduct_price());
			System.out.println();
			if (productCost.getCategories().getCategory_type().equalsIgnoreCase("A")) {

				totalSalesTaxPerItem = productCost.getProduct_price() * 0.1 * productCost.getQuantity();
				totalAmountPerItem = productCost.getProduct_price() * productCost.getQuantity() + totalSalesTaxPerItem;

				totalsalestax += productCost.getProduct_price() * 0.1 * productCost.getQuantity();

				totalprice += productCost.getProduct_price() * productCost.getQuantity()
						+ productCost.getProduct_price() * 0.1 * productCost.getQuantity();

				bill.setTotalsalestax(totalsalestax);
				bill.setTotalcost(totalprice);
				bill.setDate(date);
				order.setTaxAmount(totalSalesTaxPerItem);
				order.setTotalAmount(totalAmountPerItem);
				log.info("Unit price of item " + productCost.getProduct_price());
				log.info("SalesTax per Item " + totalSalesTaxPerItem + "\n" + "Amount per Item " + totalAmountPerItem);

				log.info("total calculated tax " + totalsalestax + "\n" + "totalprice " + totalprice);
				System.out.println();
			} else if (productCost.getCategories().getCategory_type().equalsIgnoreCase("B")) {

				totalSalesTaxPerItem = productCost.getProduct_price() * 0.2 * productCost.getQuantity();
				totalAmountPerItem = productCost.getProduct_price() * productCost.getQuantity() + totalSalesTaxPerItem;

				totalsalestax += productCost.getProduct_price() * 0.2 * productCost.getQuantity();

				totalprice += productCost.getProduct_price() * productCost.getQuantity()
						+ productCost.getProduct_price() * 0.2 * productCost.getQuantity();

				bill.setTotalsalestax(totalsalestax);
				bill.setTotalcost(totalprice);
				bill.setDate(date);
				order.setTaxAmount(totalSalesTaxPerItem);
				order.setTotalAmount(totalAmountPerItem);
				log.info("Unit price of item " + productCost.getProduct_price());
				log.info("SalesTax per Item " + totalSalesTaxPerItem + "\n" + "Amount per Item " + totalAmountPerItem);
				log.info("total calculated tax " + totalsalestax + "\n" + "totalprice " + totalprice);
				System.out.println();
			} else {

				totalprice += productCost.getProduct_price() * productCost.getQuantity();

				totalSalesTaxPerItem = 0.0;
				totalAmountPerItem = productCost.getProduct_price() * productCost.getQuantity();

				bill.setTotalsalestax(0.0);
				bill.setTotalcost(productCost.getProduct_price() * productCost.getQuantity());
				bill.setDate(date);
				order.setTaxAmount(totalSalesTaxPerItem);
				order.setTotalAmount(totalAmountPerItem);
				log.info("Unit price of item " + productCost.getProduct_price());

				log.info("SalesTax per Item " + totalSalesTaxPerItem + "\n" + "Amount per Item " + totalAmountPerItem);
				System.out.println();
			}
			orderdetails.add(order);
			orderRepository.save(order);
			bill.setCartItems(orderdetails);
		}

		totalcostandtax.add(bill);
		log.info("orederlist " + orderdetails.toString());
		log.info("final total amount: " + totalprice + "\n" + "final total sales " + totalsalestax);
		billRepository.saveAll(totalcostandtax);
		return bill;
	}

}
