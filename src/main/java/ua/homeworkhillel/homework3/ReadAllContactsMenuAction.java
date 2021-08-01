package ua.homeworkhillel.homework3;

public class ReadAllContactsMenuAction implements MenuAction{
    private ContactsService phoneBook;

    public ReadAllContactsMenuAction(ContactsService phoneBook) {
        this.phoneBook = phoneBook;
    }

    @Override
    public void doAction() {
        System.out.println(getAllContacts());
    }

    private String getAllContacts(){
        StringBuilder allContacts = new StringBuilder(String.format(" №  %-10s %s", "Имя", "Номер"));
        allContacts.append(System.lineSeparator());
        for (int i = 0; i < phoneBook.size(); i++) {
            allContacts.append(String.format("%2d. %-10s %s", i + 1, phoneBook.get(i).getName(), phoneBook.get(i).getNumber()));
            allContacts.append(System.lineSeparator());
        }
        return allContacts.toString();
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
