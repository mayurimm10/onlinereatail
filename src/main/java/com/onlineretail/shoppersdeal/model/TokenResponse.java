package com.onlineretail.shoppersdeal.model;

public class TokenResponse {
	private final String jwttoken;

	public TokenResponse(String jwttoken) {
		this.jwttoken = jwttoken;
	}

	public String getToken() {
		return this.jwttoken;
	}
}
