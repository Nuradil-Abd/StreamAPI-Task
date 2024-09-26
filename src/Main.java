import dao.impl.ContactDaoImpl;
import dao.impl.PhoneDaoImpl;
import db.Database;
import models.Contact;
import models.Phone;
import service.ContactService;
import service.PhoneService;
import service.impl.ContactServiceImpl;
import service.impl.PhoneServiceImpl;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Database database = new Database();

        ContactService contactService = new ContactServiceImpl(new ContactDaoImpl(database));
        PhoneService phoneService = new PhoneServiceImpl(new PhoneDaoImpl(database));



        Phone phone = new Phone("SmartPhone","Sumsung",new ArrayList<>());
        Phone phone2 = new Phone( "iPhone 14", "Apple", new ArrayList<>());
        Phone phone3 = new Phone( "Galaxy S22", "Samsung", new ArrayList<>());


        System.out.println(phoneService.addPhone(phone));
        phoneService.addPhone(phone2);
        phoneService.addPhone(phone3);

        List<Phone> phones = phoneService.getAllPhones();
        System.out.println("~~~~~~~All Phones~~~~~~");
        phones.forEach(System.out::println);

        phoneService.updatePhoneNameById(2L, "IPhone 15 pro");
        System.out.println("~~~~~~~All Phones after update~~~~~~");
        phones.forEach(System.out::println);

        System.out.println("phoneService.getPhoneById(2L) = " + phoneService.getPhoneById(2L));

        Contact contact1 = new Contact("Alina", "+996500400300");
        Contact contact2 = new Contact("Bektur ", "+996777123321");
        Contact contact3 = new Contact("Kemal", "+7926400600222");
        Contact contact4 = new Contact("Bermet", "+996555465987");

        System.out.println(contactService.addContactToPhone(2L, contact1));
        contactService.addContactToPhone(2L, contact2);
        contactService.addContactToPhone(2L, contact3);
        System.out.println(contactService.addContactToPhone(1L, contact3));
        System.out.println(contactService.addContactToPhone(1L, contact3));
        contactService.addContactToPhone(1L, contact4);
        contactService.addContactToPhone(1L, contact2);
        contactService.addContactToPhone(1L, contact1);

        System.out.println(phoneService.getPhoneById(1L));
        System.out.println("~~~~~~~~Find by name~~~~~~~~~~~~");
        System.out.println(contactService.findContactByName(1L, "Kemal"));


        System.out.println("~~~~~~~~after Sorted~~~~~~~~~~~~");
        List<Contact> afterSorted = contactService.sortContactsByName(1L);
        afterSorted.forEach(System.out::println);


        phoneService.deletePhoneByID(3L);
        System.out.println("~~~~~~~~after deleted~~~~~~~~~~~~");
        database.getPhones().forEach(System.out::println);




    }
}