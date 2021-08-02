package ua.homeworkhillel.homework3;

import java.util.Scanner;

public class FindContactMenuAction implements MenuAction{
    Scanner scanner;
    private ContactsService phoneBook;

    public FindContactMenuAction(Scanner scanner, ContactsService phoneBook) {
        this.scanner = scanner;
        this.phoneBook = phoneBook;
    }

    @Override
    public void doAction() {
        System.out.print("Введите имя или начальные буквы: ");
        String nameLetters = scanner.nextLine();
        System.out.println(phoneBook.findByLetters(nameLetters));
    }

    @Override
    public String getName() {
        return "Найти контакт";
    }

    @Override
    public boolean closeAfter() {
        return false;
    }
}
