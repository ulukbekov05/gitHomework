package service.serviceimpl;

import database.DB;
import model.Contact;
import model.Phone;
import service.ContactService;

import java.util.Comparator;
import java.util.List;

public class ContactServiceImpl implements ContactService {
    @Override
    public String addContactToPhone(int phoneId, Contact contact) {
        try {
            if (contact == null) {
                throw new Exception("Контакт не может быть null!");
            }

            Phone phone = DB.phones.stream()
                    .filter(p -> p.getId() == phoneId)
                    .findFirst()
                    .orElseThrow(() -> new Exception("Телефон с ID " + phoneId + " не найден!"));

            phone.getContacts().add(contact);
            return "Контакт успешно добавлен!";
        } catch (Exception e) {
            return "Ошибка: " + e.getMessage();
        }
    }

    @Override
    public Contact findContactByName(int phoneId, String contactName) {
        try {
            if (contactName == null || contactName.isBlank()) {
                throw new Exception("Имя контакта не может быть пустым!");
            }

            Phone phone = DB.phones.stream()
                    .filter(p -> p.getId() == phoneId)
                    .findFirst()
                    .orElseThrow(() -> new Exception("Телефон не найден!"));

            return phone.getContacts().stream()
                    .filter(c -> c.getName().equalsIgnoreCase(contactName))
                    .findFirst()
                    .orElseThrow(() -> new Exception("Контакт с именем '" + contactName + "' не найден!"));

        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
            return null;
        }
    }

    @Override
    public Contact findContactByPhoneNumber(int phoneId, String phoneNumber) {
        try {
            if (phoneNumber == null || phoneNumber.isBlank()) {
                throw new Exception("Номер не может быть пустым!");
            }

            Phone phone = DB.phones.stream()
                    .filter(p -> p.getId() == phoneId)
                    .findFirst()
                    .orElseThrow(() -> new Exception("Телефон не найден!"));

            return phone.getContacts().stream()
                    .filter(c -> c.getPhoneNumber().equals(phoneNumber))
                    .findFirst()
                    .orElseThrow(() -> new Exception("Контакт с номером '" + phoneNumber + "' не найден!"));

        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
            return null;
        }
    }

    @Override
    public List<Contact> sortContactsByName(int phoneId) {
        try {
            Phone phone = DB.phones.stream()
                    .filter(p -> p.getId() == phoneId)
                    .findFirst()
                    .orElseThrow(() -> new Exception("Телефон не найден!"));

            return phone.getContacts().stream()
                    .sorted(Comparator.comparing(Contact::getName))
                    .toList();

        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
            return List.of();
        }
    }

    @Override
    public void deleteContactByNameFromPhone(int phoneId, String contactName) {
        try {
            if (contactName == null || contactName.isBlank()) {
                throw new Exception("Имя контакта не может быть пустым!");
            }

            Phone phone = DB.phones.stream()
                    .filter(p -> p.getId() == phoneId)
                    .findFirst()
                    .orElseThrow(() -> new Exception("Телефон не найден!"));

            Contact contact = phone.getContacts().stream()
                    .filter(c -> c.getName().equalsIgnoreCase(contactName))
                    .findFirst()
                    .orElseThrow(() -> new Exception("Контакт '" + contactName + "' не найден!"));

            phone.getContacts().remove(contact);
            System.out.println("Контакт успешно удалён!");

        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
}
