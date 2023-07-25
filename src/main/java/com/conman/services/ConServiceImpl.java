package com.conman.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.conman.model.Contact;
import com.conman.repos.ConRepository;

@Service
public class ConServiceImpl implements ConService {

	@Autowired
	private ConRepository conRepo;

	@Override
	public Iterable<Contact> listAllContacts() {
		return conRepo.findAll();
	}

	@Override
	public Optional<Contact> getContactByEmailId(String emailId) {
		return conRepo.findById(emailId);
	}

	@Override
	public Contact saveContact(Contact contact) {
		return conRepo.save(contact);
	}

	@Override
	public void deleteContact(String email) {
		conRepo.deleteById(email);
	}

}
