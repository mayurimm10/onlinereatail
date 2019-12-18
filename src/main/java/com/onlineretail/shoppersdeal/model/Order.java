package com.onlineretail.shoppersdeal.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * 
 * @author Intelliswift.Test1
 *
 */
@Entity
@Table(name = "cart")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "cartId")
	private Integer cartId;

	@NotNull
	@Column(name = "product_id")
	private Integer productid;

	@NotNull
	@Column(name = "product_name")
	private String productName;

	@NotNull
	@Column(name = "unit_price")
	private Double unitPrice;

	@NotNull
	@Column(name = "tax_applied")
	private Integer tax_applied;

	@NotNull
	@Column(name = "quantity")
	private Integer quantity;

	@NotNull
	@Column(name = "tax_amount")
	private Double taxAmount;

	@NotNull
	@Column(name = "total_amount")
	private Double totalAmount;

	@NotNull
	public Integer getCartId() {
		return cartId;
	}

	public void setCartId(Integer cartId) {
		this.cartId = cartId;
	}

	public Integer getProductid() {
		return productid;
	}

	public void setProductid(Integer productid) {
		this.productid = productid;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(Double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public Integer getTax_applied() {
		return tax_applied;
	}

	public void setTax_applied(Integer tax_applied) {
		this.tax_applied = tax_applied;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getTaxAmount() {
		return taxAmount;
	}

	public void setTaxAmount(Double taxAmount) {
		this.taxAmount = taxAmount;
	}

	public Double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}

	@Override
	public String toString() {
		return "Order [cartId=" + cartId + ", productid=" + productid + ", productName=" + productName + ", unitPrice="
				+ unitPrice + ", tax_applied=" + tax_applied + ", quantity=" + quantity + ", taxAmount=" + taxAmount
				+ ", totalAmount=" + totalAmount + "]";
	}

}
