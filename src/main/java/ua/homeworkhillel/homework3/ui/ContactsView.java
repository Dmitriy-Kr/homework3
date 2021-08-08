package ua.homeworkhillel.homework3.ui;

import ua.homeworkhillel.homework3.services.Contact;
import ua.homeworkhillel.homework3.services.ContactsList;

public class ContactsView {
    public void showContact(Contact contact) {
        System.out.printf("%-10s %s", contact.getName(), contact.getNumber());
    }

    public void showAllContacts(ContactsList contactsList){
        System.out.printf("№   %-10s %s%s", "Имя", "Номер телефона", System.lineSeparator());
        for (int i = 0; i < contactsList.size(); i++) {
            System.out.printf("%d. ", i + 1);
            showContact(contactsList.get(i));
            System.out.println();
        }
    }
}
