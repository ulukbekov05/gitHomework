package service.serviceimpl;

import model.Phone;
import service.PhoneService;

import java.util.List;

public class PhoneServiceImpl implements PhoneService {


    @Override
    public String addPhone(Phone phone) {
        return "";
    }

    @Override
    public Phone getPhoneById(int phoneId) {
        return null;
    }

    @Override
    public Phone updatePhoneNameById(int phoneId, String newName) {
        return null;
    }

    @Override
    public List<Phone> getAllPhones() {
        return List.of();
    }

    @Override
    public List<Phone> getAllPhonesByBrand(String brand) {
        return List.of();
    }

    @Override
    public void deletePhoneById(int phoneId) {

    }
}
