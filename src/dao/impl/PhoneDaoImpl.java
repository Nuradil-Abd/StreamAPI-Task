package dao.impl;

import dao.PhoneDao;
import db.Database;
import models.Phone;

import java.util.List;
import java.util.Optional;

public class PhoneDaoImpl implements PhoneDao {
    private  Database database;

    public PhoneDaoImpl(Database database) {
        this.database = database;
    }

    @Override
    public void addPhone(Phone phone) {
        database.getPhones().add(phone);

    }

    @Override
    public Phone getPhoneById(Long id) {
        return database.getPhones().stream()
                .filter(phone -> phone.getId().equals (id))
                .findFirst().orElse(null);
    }

    @Override
    public void updatePhoneNameById(Long id, String name) {
        Optional<Phone> phoneOptional = database.getPhones().stream()
                .filter(phone -> phone.getId().equals(id))
                .findFirst();
        phoneOptional.ifPresent(phone -> phone.setName(name));
    }
    public List<Phone>getAllPhones(){
        return database.getPhones();
    }

    @Override
    public List<Phone> getAllPhoneByBrand(String brand) {
        return database.getPhones().stream()
                .filter(phone -> phone.getBrand().equalsIgnoreCase(brand)).toList();
    }

    @Override
    public void deletePhoneByID(Long id) {
        database.getPhones().removeIf(phone -> phone.getId().equals(id));

    }
}
