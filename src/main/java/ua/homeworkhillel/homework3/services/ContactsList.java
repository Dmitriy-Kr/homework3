package ua.homeworkhillel.homework3.services;

import ua.homeworkhillel.homework3.services.Contact;

import java.util.NoSuchElementException;

public class ContactsList {
    Contact[] contacts;

    public Contact get(int index) {
        if (index < 0 || index > contacts.length - 1) {
            throw new NoSuchElementException();
        }
        return contacts[index];
    }

    public void set(int index, Contact c) {
        if (index < 0 || index > contacts.length - 1) {
            throw new NoSuchElementException();
        }
        contacts[index] = c;
    }

    public int size() {
        return contacts.length;
    }

    public void remove(int index) {
        if (index < 0 || index > contacts.length - 1) {
            throw new NoSuchElementException();
        }
        Contact[] contactsNew = new Contact[contacts.length - 1];
        for (int i = 0; i < index; i++) {
            contactsNew[i] = contacts[i];
        }
        for (int i = index + 1; i < contacts.length; i++) {
            contactsNew[i - 1] = contacts[i];
        }
        contacts = contactsNew;
    }

    public void add(Contact c) {
        if (contacts == null) {
            contacts = new Contact[1];
            contacts[0] = c;
        } else {
            Contact[] contactsNew = new Contact[contacts.length + 1];
            for (int i = 0; i < contacts.length; i++) {
                contactsNew[i] = contacts[i];
            }
            contacts = contactsNew;
            contacts[contacts.length - 1] = c;
        }
    }
}
