package com.hibernate.dao;

public class IdNotFoundException extends RuntimeException{

	public IdNotFoundException(String str) {
		super(str);
	}
}
