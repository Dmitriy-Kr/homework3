package ua.homeworkhillel.homework3;

public class ReadAllContactsMenuAction implements MenuAction{
    private ContactsService phoneBook;

    public ReadAllContactsMenuAction(ContactsService phoneBook) {
        this.phoneBook = phoneBook;
    }

    @Override
    public void doAction() {
        System.out.println(phoneBook.getAllString());
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
