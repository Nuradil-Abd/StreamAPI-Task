package service.impl;

import dao.ContactDao;
import exceptions.NotFoundException;
import models.Contact;
import models.Phone;
import service.ContactService;

import java.util.List;

public class ContactServiceImpl implements ContactService {
    ContactDao contactDao;

    public ContactServiceImpl(ContactDao contactDao) {
        this.contactDao = contactDao;
    }

    @Override
    public String addContactToPhone(Long phoneId, Contact contact) {
        try {
            contactDao.addContactToPhone(phoneId, contact);
            return "Contact added successfully";
        }catch (IllegalArgumentException e){
            return e.getMessage();
        }
    }

    @Override
    public Contact findContactByName(Long phoneId, String contactName) {
        Contact contact = contactDao.findContactByName(phoneId,contactName);
        if(contact == null){
            throw new NotFoundException("Contact not found");
        }
        return contact;
    }

    @Override
    public Contact findContactByPhoneNumber(Long phoneId, String phoneNumber) {
        return contactDao.findContactByPhoneNumber(phoneId, phoneNumber);
    }

    @Override
    public List<Contact> sortContactsByName(Long phoneId) {
        return contactDao.sortContactsByName(phoneId);
    }
}
