package dao;

import models.Phone;

import java.util.List;

public interface PhoneDao {
    void addPhone(Phone phone);

    Phone getPhoneById(Long id);

    void updatePhoneNameById(Long id, String name);

    List<Phone> getAllPhones();

    List<Phone> getAllPhoneByBrand(String brand);

    void deletePhoneByID(Long id);
}
