package dao.impl;

import dao.ContactDao;
import db.Database;
import models.Contact;
import models.Phone;

import java.util.List;

public class ContactDaoImpl implements ContactDao {

    private Database database;

    public ContactDaoImpl(Database database) {
        this.database = database;
    }

    @Override
    public void addContactToPhone(Long phoneId, Contact contact) {
        Phone phone = database.getPhones().stream()
                .filter(p -> p.getId() == phoneId)
                .findFirst().orElse(null);
        if(phone != null){

            boolean contactExists = phone.getContacts().stream()
                    .anyMatch(targetContact -> targetContact.getName().equalsIgnoreCase(contact.getName()));

            if (contactExists){
                throw new IllegalArgumentException("Contact with this name already exists in the phone");
            }
            phone.getContacts().add(contact);
        }



    }

    @Override
    public Contact findContactByName(Long phoneId, String contactName) {
        return database.getPhones().stream()
                .filter(phone -> phone.getId().equals(phoneId))
                .flatMap(phone -> phone.getContacts().stream() )
                .filter(contact -> contact.getName().equalsIgnoreCase(contactName))
                .findFirst().orElse(null);
    }

    @Override
    public Contact findContactByPhoneNumber(Long phoneId, String phoneNumber) {
        return database.getPhones().stream()
                .filter(phone -> phone.getId().equals(phoneId))
                .flatMap(phone -> phone.getContacts().stream())
                .filter(contact -> contact.getPhoneNumber().equalsIgnoreCase(phoneNumber))
                .findFirst().orElse(null);
    }

    @Override
    public List<Contact> sortContactsByName(Long phoneId) {
        return database.getPhones().stream()
                .filter(phone -> phone.getId().equals(phoneId))
                .flatMap(phone -> phone.getContacts().stream())
                .sorted((c1,c2) -> c1.getName().compareToIgnoreCase(c2.getName()))
                .toList();
    }
}
