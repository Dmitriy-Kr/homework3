package ua.homeworkhillel.homework3;

public class InMemoryContactsService implements ContactsService{
    private ContactsList contactsList;

    public InMemoryContactsService() {
        contactsList = new ContactsList();
    }

    @Override
    public ContactsList getAll() {
        return contactsList;
    }

    public Contact get(int index){
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

    public int size(){
        return contactsList.size();
    }
}