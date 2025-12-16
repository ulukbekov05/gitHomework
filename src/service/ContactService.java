package service;

import java.util.List;

public interface ContactService {




  String addContactToPhone(int phoneId, ContactService contactService);

// with stream (телефонду phoneId мн табып, ичинен контантактардын арасынан contactName мн табып кайтарып берсин)

 ContactService findContactByName(int phoneId, String contactName);

// with stream - ContactService findContactByPhoneNumber(int phoneId, String phoneNumber);

// with stream (телефонду phoneId мн табып, ичинен контантактарды аттарын осуу тартибинде чыгарып берсин)

List<ContactService> sortContactsByName(int phoneId);
void deleteContactByNameFromPhone(int phoneId, String contactName);

}
