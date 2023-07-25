package com.conman.repos;

import org.springframework.data.repository.CrudRepository;

import com.conman.model.Contact;

public interface ConRepository extends CrudRepository<Contact, String> {

}
