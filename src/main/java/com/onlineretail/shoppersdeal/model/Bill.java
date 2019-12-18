package com.onlineretail.shoppersdeal.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * 
 * @author Intelliswift.Test1
 *
 */
@Entity
@Table(name = "bill")
public class Bill {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "InvoiceNumber")
	private Integer InvoiceNumber;

	@NotNull
	@Column(name = "totalcost")
	private Double totalcost;
	
	@NotNull
	@Column(name = "totalsalestax")
	private Double totalsalestax;

	@NotNull
	@Column(name = "date")
	private Date date;

	
	@OneToMany(mappedBy = "cartId")
	private List<Order> cartItems;

	public Double getTotalcost() {
		return totalcost;
	}

	public Integer getInvoiceNumber() {
		return InvoiceNumber;
	}

	public void setInvoiceNumber(Integer invoiceNumber) {
		InvoiceNumber = invoiceNumber;
	}

	public void setTotalcost(Double totalcost) {
		this.totalcost = totalcost;
	}

	public Double getTotalsalestax() {
		return totalsalestax;
	}

	public void setTotalsalestax(Double totalsalestax) {
		this.totalsalestax = totalsalestax;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public List<Order> getCartItems() {
		return cartItems;
	}

	public void setCartItems(List<Order> cartItems) {
		this.cartItems = cartItems;
	}

	@Override
	public String toString() {
		return "Bill [InvoiceNumber=" + InvoiceNumber + ", totalcost=" + totalcost + ", totalsalestax=" + totalsalestax
				+ ", date=" + date + ", cartItems=" + cartItems + "]";
	}

}
