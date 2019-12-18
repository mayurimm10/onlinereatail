package com.onlineretail.shoppersdeal.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.onlineretail.shoppersdeal.model.Usertable;

@Repository
public interface UserRepository extends CrudRepository<Usertable, Integer> {
	Usertable findByUsername(String username);

}
