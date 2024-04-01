package org.example.mobile;

import java.util.ArrayList;
import java.util.List;

public class MobilePhone {
    private final String myNumber;
    private final ArrayList<Contact> myContacts;

    public MobilePhone(String myNumber, List<Contact> myContacts) {
        this.myNumber = myNumber;
        this.myContacts = new ArrayList<>(myContacts);
    }

    public String getMyNumber() {
        return myNumber;
    }

    public ArrayList<Contact> getMyContacts() {
        return myContacts;
    }

    public boolean addNewContact(Contact contact) {
        if (findContact(contact) >= 0) {
            System.out.println("Contact is already on file.");
            return false;
        }
        myContacts.add(contact);
        return true;
    }

    public boolean updateContact(Contact oldContact, Contact newContact) {
        int position = findContact(oldContact);
        if (position < 0) {
            System.out.println(oldContact.getName() + " was not found.");
            return false;
        }

        myContacts.set(position, newContact);
        System.out.println(oldContact.getName() + " was replaced with " + newContact.getName());
        return true;
    }

    public boolean removeContact(Contact contact) {
        int position = findContact(contact);
        if (position >= 0) {
            myContacts.remove(position);
            return true;
        }
        return false;
    }


    public int findContact(Contact contact) {
        for (int i = 0; i < myContacts.size(); i++) {
            if (myContacts.get(i).getName().equals(contact.getName()) && myContacts.get(i).getPhoneNumber().equals(contact.getPhoneNumber())) {
                return i;
            }
        }
        return -1;
    }

    public int findContact(String contactName) {
        for (int i = 0; i < myContacts.size(); i++) {
            Contact contact = myContacts.get(i);
            if (contact.getName().equals(contactName)) {
                return i;
            }
        }
        return -1;
    }

    public Contact queryContact(String name) {
        int position = findContact(name);
        if (position >= 0) {
            return myContacts.get(position);
        }
        return null;
    }


    public void printContacts() {
        System.out.println("Contact List:");
        for (Contact contact : myContacts) {
            System.out.println(contact.getName() + " -> " + contact.getPhoneNumber());
        }
    }
}
