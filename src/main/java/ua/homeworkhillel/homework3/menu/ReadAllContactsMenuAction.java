package ua.homeworkhillel.homework3.menu;

import ua.homeworkhillel.homework3.menu.MenuAction;
import ua.homeworkhillel.homework3.services.ContactsService;
import ua.homeworkhillel.homework3.ui.ContactsView;

public class ReadAllContactsMenuAction implements MenuAction {
    private ContactsService phoneBook;
    private ContactsView contactsView;

    public ReadAllContactsMenuAction(ContactsService phoneBook, ContactsView contactsView) {
        this.phoneBook = phoneBook;
        this.contactsView = contactsView;
    }

    @Override
    public void doAction() {
        System.out.println("--------------------------------------------------");
        contactsView.showAllContacts(phoneBook.getAll());
        System.out.println("--------------------------------------------------");
    }

    @Override
    public String getName() {
        return "Показать все контакты";
    }

    @Override
    public boolean closeAfter() {
        return false;
    }
}
