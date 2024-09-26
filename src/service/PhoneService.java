package service;

import models.Phone;

import java.util.List;

public interface PhoneService {
    String addPhone(Phone phone);
    Phone getPhoneById(Long id);
    Phone updatePhoneNameById(Long id, String name);
    List<Phone> getAllPhones();
    List<Phone> getAllPhonesByBrand(String brand);
    void deletePhoneByID( Long id);
}
