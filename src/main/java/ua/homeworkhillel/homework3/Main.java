package ua.homeworkhillel.homework3;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ContactsService phoneBook = new InMemoryContactsService();
//        ContactsService phoneBook = new FileContactsService();
        Menu menu = new Menu(scanner);

        phoneBook.add(new Contact("Иван", "+380975882032"));
        phoneBook.add(new Contact("Артём", "+380965882032"));
        phoneBook.add(new Contact("Игорь", "+380955582032"));
        phoneBook.add(new Contact("Максим", "+380955882932"));
        phoneBook.add(new Contact("Денис", "+380958112932"));

        menu.addAction(new ReadAllContactsMenuAction(phoneBook));
        menu.addAction(new AddContactMenuAction(scanner, phoneBook));
        menu.addAction(new RemoveContactMenuAction(scanner, phoneBook));
        menu.addAction(new FindContactMenuAction(scanner, phoneBook));
        menu.addAction(new ExitMenuAction());

        menu.run();
    }
}
