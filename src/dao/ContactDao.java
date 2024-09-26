package dao;

import models.Contact;

import java.util.List;

public interface ContactDao {
    void addContactToPhone(Long phoneId, Contact contact);

    Contact findContactByName(Long phoneId, String contactName);

    Contact findContactByPhoneNumber(Long phoneId,String phoneNumber);

    List<Contact> sortContactsByName(Long phoneId);
}
