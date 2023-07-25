package com.conman.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.conman.model.Contact;
import com.conman.services.ConService;

@Controller
public class ContactController {

	@Autowired
	private ConService conServ;

	@RequestMapping(value = "/contacts", method = RequestMethod.GET)
	public String listContact(Model model) {
		model.addAttribute("contacts", conServ.listAllContacts());
		return "contacts";
	}

	@RequestMapping("contact/{emailId}")
	public String showContact(@PathVariable String emailId, Model model) {
		conServ.getContactByEmailId(emailId).ifPresent(con -> model.addAttribute("contact", con));
		return "viewcontact";
	}

	@RequestMapping("contact/new")
	public String newContact(Model model) {
		model.addAttribute("contact", new Contact());
		return "addcontact";
	}

	@RequestMapping(value = "contact", method = RequestMethod.POST)
	public String saveContact(Contact contact) {
		conServ.saveContact(contact);
		return "redirect:/contact/" + contact.getEmailId();
	}

	@RequestMapping("contact/delete/{emailId}")
	public String deleteContact(@PathVariable String emailId) {
		conServ.deleteContact(emailId);
		return "redirect:/contacts";
	}

	@RequestMapping("contact/edit/{emailId}")
	public String editContact(@PathVariable String emailId, Model model) {
		
		List<Contact> cons = (List<Contact>) conServ.listAllContacts();
		Contact con = null;
		if (!cons.isEmpty()) {
			for (int i = 0; i < cons.size(); i++) {
				con = cons.get(i);
				if (con.getEmailId() == emailId) {
					cons.set(i, con);
				}
			}
		}
		if (con != null) {
			model.addAttribute("contact", conServ.getContactByEmailId(emailId));
		}
		return "addcontact";
	}

}
