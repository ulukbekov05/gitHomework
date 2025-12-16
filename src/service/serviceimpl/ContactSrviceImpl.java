package service.serviceimpl;

import service.ContactService;

import java.util.List;

public class ContactSrviceImpl implements ContactService {



    @Override
    public String addContactToPhone(int phoneId, ContactService contactService) {
        return "";
    }

    @Override
    public ContactService findContactByName(int phoneId, String contactName) {
        return null;
    }

    @Override
    public List<ContactService> sortContactsByName(int phoneId) {
        return List.of();
    }

    @Override
    public void deleteContactByNameFromPhone(int phoneId, String contactName) {

    }
}
