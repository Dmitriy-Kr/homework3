package ua.homeworkhillel.homework3;

public class InMemoryContactsService implements ContactsService {
    private ContactsList contactsList;

    public InMemoryContactsService() {
        contactsList = new ContactsList();
    }

    @Override
    public ContactsList getAll() {
        return contactsList;
    }

    public Contact get(int index) {
        return contactsList.get(index);
    }

    @Override
    public void remove(int index) {
        contactsList.remove(index);
    }

    @Override
    public void add(Contact c) {
        contactsList.add(c);
    }

    public int size() {
        return contactsList.size();
    }

    @Override
    public String getAllString() {
        StringBuilder allContacts = new StringBuilder(String.format(" №  %-10s %s", "Имя", "Номер"));
        allContacts.append(System.lineSeparator());
        for (int i = 0; i < contactsList.size(); i++) {
            allContacts.append(String.format("%2d. %-10s %s", i + 1, contactsList.get(i).getName(), contactsList.get(i).getNumber()));
            allContacts.append(System.lineSeparator());
        }
        return allContacts.toString();
    }

    @Override
    public String findByLetters(String nameLetters) {
        StringBuilder findContacts = new StringBuilder(String.format("%-10s %s%s", "Имя", "Номер", System.lineSeparator()));
        for (int i = 0; i < contactsList.size(); i++) {
            if (nameLetters.equalsIgnoreCase(contactsList.get(i).getName().substring(0, nameLetters.length()))) {
                findContacts.append(String.format("%-10s %s", contactsList.get(i).getName(), contactsList.get(i).getNumber()));
                findContacts.append(System.lineSeparator());
            }
        }
        return findContacts.toString();
    }
}