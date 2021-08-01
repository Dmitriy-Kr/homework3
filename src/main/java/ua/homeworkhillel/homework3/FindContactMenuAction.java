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
        System.out.printf("%-10s %s%s", "Имя", "Номер", System.lineSeparator());
        for (int i = 0; i < phoneBook.size(); i++) {
            if(nameLetters.equalsIgnoreCase(phoneBook.get(i).getName().substring(0, nameLetters.length()))) {
                System.out.printf("%-10s %s", phoneBook.get(i).getName(), phoneBook.get(i).getNumber());
                System.out.println();
            }
        }
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
