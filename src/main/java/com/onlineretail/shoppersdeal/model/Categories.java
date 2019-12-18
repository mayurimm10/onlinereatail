package com.onlineretail.shoppersdeal.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * 
 * @author Intelliswift.Test1
 *
 */

@Entity
@Table(name = "categories")
public class Categories {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "category_id")
	private Integer category_id;
	@NotNull
	@Column(name = "category_type")
	private String category_type;

	@NotNull
	@OneToOne
	@JoinColumn(name = "sales_id")
	private SalesTax salesTax;

	public Integer getCategory_id() {
		return category_id;
	}

	public void setCategory_id(Integer category_id) {
		this.category_id = category_id;
	}

	public SalesTax getSalesTax() {
		return salesTax;
	}

	public void setSalesTax(SalesTax salesTax) {
		this.salesTax = salesTax;
	}

	public String getCategory_type() {
		return category_type;
	}

	public void setCategory_type(String category_type) {
		this.category_type = category_type;
	}

}
