package ua.homeworkhillel.homework3;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class FileContactsService implements ContactsService {
    private ContactsList contactsList;
    private Path file = Paths.get("phonebook.txt");

    public FileContactsService() {
        contactsList = contactsListFromString(readFile());
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
        writeToFile(stringFromContactsList());
    }

    @Override
    public void add(Contact c) {
        contactsList.add(c);
        writeToFile(stringFromContactsList());
    }

    public int size() {
        return contactsList.size();
    }

    public String readFile() {
        StringBuilder result = new StringBuilder();
        try (Scanner scanner = new Scanner(file, StandardCharsets.UTF_8);) {
            while (scanner.hasNextLine()) {
                result.append(scanner.nextLine()).append(" ");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result.toString().trim();
    }

    public ContactsList contactsListFromString(String s) {
        ContactsList cL = new ContactsList();
        String[] linesArray = s.split(" ");
        for (int i = 0; i < linesArray.length; i += 2) {
            cL.add(new Contact(linesArray[i], linesArray[i + 1]));
        }
        return cL;
    }

    public String stringFromContactsList(){
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < contactsList.size(); i++) {
            result.append(contactsList.get(i).getName()).append(" ");
            result.append(contactsList.get(i).getNumber());
            if (i != contactsList.size() - 1) {
                result.append(System.lineSeparator());
            }
        }

        return result.toString();
    }

    public void writeToFile(String output) {
        try (FileWriter fw = new FileWriter(file.toFile(), StandardCharsets.UTF_8)) {
            fw.write(output);
            fw.flush();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
