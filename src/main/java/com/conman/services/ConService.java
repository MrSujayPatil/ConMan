package com.conman.services;

import java.util.Optional;

import com.conman.model.Contact;

public interface ConService {

	public Iterable<Contact> listAllContacts();

	public Optional<Contact> getContactByEmailId(String emailId);

	public Contact saveContact(Contact contact);

	public void deleteContact(String emailId);
}
