package service.impl;

import dao.PhoneDao;
import exceptions.NotFoundException;
import models.Phone;
import service.PhoneService;

import java.util.List;

public class PhoneServiceImpl implements PhoneService {
    private PhoneDao phoneDao;

    public PhoneServiceImpl(PhoneDao phoneDao) {
        this.phoneDao = phoneDao;
    }

    @Override
    public String addPhone(Phone phone) {
        if(phoneDao.getPhoneById(phone.getId()) != null){
            return "Phone with id " + phone.getId() + " already exists!";
        }
        phoneDao.addPhone(phone);
        return "Phone added successfully";

    }

    @Override
    public Phone getPhoneById(Long id) {
        Phone phone = phoneDao.getPhoneById(id);
        if(phone == null) {
            throw new NotFoundException("Phone not found");
        }
        return phone;
    }



    public Phone updatePhoneNameById(Long id, String name){
        Phone phone = phoneDao.getPhoneById(id);
        if(phone == null){
            throw new NotFoundException("Phone not found");
        }
        phoneDao.updatePhoneNameById(id,name);
        return phoneDao.getPhoneById(id);
    }

    @Override
    public List<Phone> getAllPhones() {
        return phoneDao.getAllPhones();
    }

    @Override
    public List<Phone> getAllPhonesByBrand(String brand) {
        return phoneDao.getAllPhoneByBrand(brand);
    }

    @Override
    public void deletePhoneByID(Long id) {
        Phone phone = phoneDao.getPhoneById(id);
        if(phone == null){
            throw new NotFoundException("Phone not found");
        }
        phoneDao.deletePhoneByID(id);

    }


}
