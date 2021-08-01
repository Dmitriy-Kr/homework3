package ua.homeworkhillel.homework3;

public interface ContactsService {
    ContactsList getAll();
    void remove(int index);
    void add(Contact c);
    Contact get(int index);
    int size();
}
