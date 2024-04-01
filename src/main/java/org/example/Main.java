package org.example;

import org.example.mobile.Contact;
import org.example.mobile.MobilePhone;
import org.example.models.Grocery;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Contact> contacts = new ArrayList<>();
        contacts.add(new Contact("John Doe", "123123123"));
        contacts.add(new Contact("Jane Doe", "124124124"));
        contacts.add(new Contact("Baby Doe", "125125125"));

        MobilePhone mobilePhone = new MobilePhone("11111111", contacts);

        Contact contact1 = Contact.createContact("Bob", "31415926");
        Contact contact2 = Contact.createContact("Alice", "16180339");
        Contact contact3 = Contact.createContact("Tom", "11235813");
        Contact contact4 = Contact.createContact("Jane", "23571113");

        mobilePhone.addNewContact(contact1);
        mobilePhone.addNewContact(contact2);
        mobilePhone.addNewContact(contact3);
        mobilePhone.addNewContact(contact4);

        mobilePhone.printContacts();

        Contact newContact = Contact.createContact("John", "98765432");
        mobilePhone.updateContact(contact1, newContact);

        mobilePhone.printContacts();

        mobilePhone.removeContact(contact2);

        mobilePhone.printContacts();

        Contact foundContact = mobilePhone.queryContact("Tom");
        System.out.println("Found contact: " + foundContact.getName() + " -> " + foundContact.getPhoneNumber());

        Grocery.startGrocery();
    }
}
