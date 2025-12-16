import model.Contact;
import model.Phone;
import service.serviceimpl.ContactServiceImpl;
import service.serviceimpl.PhoneServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        PhoneServiceImpl phoneService = new PhoneServiceImpl();
        ContactServiceImpl contactService = new ContactServiceImpl();

        boolean isWork = true;

        while (isWork) {
            System.out.println("""
                        \n=== MAIN MENU ===
                        1) Phone
                        2) Contact
                        3) Exit
                        """);

            String choice = sc.nextLine();

            switch (choice) {
                case "1" -> {
                    boolean phoneMenu = true;
                    while (phoneMenu) {
                        System.out.println("""
                                    \n--- PHONE MENU ---
                                    1) Add phone
                                    2) Get all phones
                                    3) Update phone name
                                    4) Delete phone
                                    5) Back
                                    """);
                        String c = sc.nextLine();
                        switch (c) {
                            case "1" -> {
                                System.out.println("ID:");
                                long id = safeLong();
                                System.out.println("Name:");
                                String name = safeString();
                                System.out.println("Brand:");
                                String brand = safeString();
                                Phone phone = new Phone(id, name, brand, new ArrayList<>());
                                System.out.println(phoneService.addPhone(phone));
                            }
                            case "2" -> {
                                System.out.println("All phones:");
                                for (Phone p : phoneService.getAllPhones()) {
                                    System.out.println(p);
                                }
                            }
                            case "3" -> {
                                System.out.println("Phone ID:");
                                int id = safeInt();
                                System.out.println("New name:");
                                String newName = safeString();
                                System.out.println(phoneService.updatePhoneNameById(id, newName));
                            }
                            case "4" -> {
                                System.out.println("Phone ID:");
                                int id = safeInt();
                                phoneService.deletePhoneById(id);
                            }
                            case "5" -> phoneMenu = false;
                            default -> System.out.println("Invalid choice!");
                        }
                    }
                }

                case "2" -> {
                    boolean contactMenu = true;
                    while (contactMenu) {
                        System.out.println("""
                                    \n--- CONTACT MENU ---
                                    1) Add contact to phone
                                    2) Find contact by name
                                    3) Find contact by number
                                    4) Sort contacts by name
                                    5) Delete contact by name
                                    6) Back
                                    """);
                        String c = sc.nextLine();
                        switch (c) {
                            case "1" -> {
                                System.out.println("Phone ID:");
                                int phoneId = safeInt();
                                System.out.println("Contact name:");
                                String name = safeString();
                                System.out.println("Phone number:");
                                String number = safeString();
                                Contact contact = new Contact(name, number);
                                System.out.println(contactService.addContactToPhone(phoneId, contact));
                            }
                            case "2" -> {
                                System.out.println("Phone ID:");
                                int phoneId = safeInt();
                                System.out.println("Contact name:");
                                String name = safeString();
                                Contact cObj = contactService.findContactByName(phoneId, name);
                                if (cObj != null) System.out.println(cObj);
                            }
                            case "3" -> {
                                System.out.println("Phone ID:");
                                int phoneId = safeInt();
                                System.out.println("Phone number:");
                                String name = safeString();
                                Contact cObj = contactService.findContactByName(phoneId, name);
                                if (cObj != null) System.out.println(cObj);
                            }
                            case "4" -> {
                                System.out.println("Phone ID:");
                                int phoneId = safeInt();
                                List<Contact> sorted = contactService.sortContactsByName(phoneId);
                                System.out.println("Sorted contacts:");
                                for (Contact cObj : sorted) {
                                    System.out.println(cObj);
                                }
                            }
                            case "5" -> {
                                System.out.println("Phone ID:");
                                int phoneId = safeInt();
                                System.out.println("Contact name:");
                                String name = safeString();
                                contactService.deleteContactByNameFromPhone(phoneId, name);
                            }
                            case "6" -> contactMenu = false;
                            default -> System.out.println("Invalid choice!");
                        }
                    }
                }

                case "3" -> {
                    System.out.println("Exiting...");
                    isWork = false;
                }

                default -> System.out.println("Invalid choice!");
            }
        }
    }

    public static Scanner sc=new Scanner(System.in);
    public static long safeLong() {
        while (true) {
            try {
                System.out.print("> ");
                return Long.parseLong(sc.nextLine());
            } catch (Exception e) {
                System.out.println("Enter valid Long ID!");
            }
        }
    }

    public static int safeInt() {
        while (true) {
            try {
                System.out.print("> ");
                return Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.out.println("Enter valid number!");
            }
        }
    }

    public static String safeString() {
        while (true) {
            String s = sc.nextLine();
            if (!s.isBlank()) return s;
            System.out.println("Field cannot be empty!");
        }
    }









    }
