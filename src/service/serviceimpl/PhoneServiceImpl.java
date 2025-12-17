package service.serviceimpl;

import database.DB;
import model.Phone;
import service.PhoneService;

import java.util.List;

public class PhoneServiceImpl implements PhoneService {


    @Override
    public String addPhone(Phone phone) {
        try {
            if (phone == null) {
                throw new Exception("Телефон не может быть null!");
            }
            DB.phones.add(phone);
            return "Успешно добавили!";
        } catch (Exception e) {
            return "Ошибка: " + e.getMessage();
        }
    }

    @Override
    public Phone getPhoneById(int phoneId) {
        try {
            return DB.phones.stream()
                    .filter(phone -> phone.getId() == phoneId)
                    .findFirst()
                    .orElseThrow(() -> new Exception("Телефон с ID " + phoneId + " не найден!"));
        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
            return null;
        }
    }

    @Override
    public Phone updatePhoneNameById(int phoneId, String newName) {
        try {
            if (newName == null || newName.isBlank()) {
                throw new Exception("Имя не может быть пустым!");
            }

            Phone phone = getPhoneById(phoneId);
            if (phone == null) {
                throw new Exception("Телефон с ID " + phoneId + " не найден!");
            }

            phone.setName(newName);
            System.out.println("Имя успешно обновлено!");
        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
        return null;
    }


    @Override
    public List<Phone> getAllPhones() {
        try {
            return DB.phones;
        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
            return List.of();
        }
    }

    @Override
    public List<Phone> getAllPhonesByBrand(String brand) {
        try {
            if (brand == null || brand.isBlank()) {
                throw new Exception("Бренд не может быть пустым!");
            }

            return DB.phones.stream()
                    .filter(phone -> phone.getBrand().equalsIgnoreCase(brand))
                    .toList();

        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
            return List.of();
        }
    }

    @Override
    public void deletePhoneById(int phoneId) {
        try {
            Phone phone = getPhoneById(phoneId);
            if (phone == null) {
                throw new Exception("Телефон с ID " + phoneId + " не найден!");
            }

            DB.phones.remove(phone);
            System.out.println( "Телефон успешно удалён!");
        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
}
