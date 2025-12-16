package service;

import model.Contact;

import java.util.List;

public interface ContactService {


    String addContactToPhone(int phoneId, Contact contact);

    Contact findContactByName(int phoneId, String contactName);

    List<Contact> sortContactsByName(int phoneId);

    void deleteContactByNameFromPhone(int phoneId, String contactName);
    Contact findContactByPhoneNumber(int phoneId, String phoneNumber);
}
