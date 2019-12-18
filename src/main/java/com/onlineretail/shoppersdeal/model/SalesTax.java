package com.onlineretail.shoppersdeal.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import javax.validation.constraints.NotNull;

/**
 * 
 * @author Intelliswift.Test1
 *
 */

@Entity
@Table(name = "salestax")
public class SalesTax {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer taxid;

	@NotNull
	@Column(name = "levy")
	private Integer levy;

	public Integer getTaxid() {
		return taxid;
	}

	public void setTaxid(Integer taxid) {
		this.taxid = taxid;
	}

	public Integer getLevy() {
		return levy;
	}

	public void setLevy(Integer levy) {
		this.levy = levy;
	}

}
