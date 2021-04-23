package arrays;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        while (true) {
            String userSelection;

            print("\nName registry");
            print("************************");
            print("Enter L to list of all names");
            print("Enter S to get size of registry");
            print("Enter A to add a new name");
            print("Enter U to update a name");
            print("Enter R to remove a name");
            print("Enter F to find by full name");
            print("Enter FF to find by first name");
            print("Enter FL to find by last name");
            print("Enter C to clear all names from registry");
            print("Press X to exit program");

            userSelection = getStringFromUser("Your choice: ").toLowerCase();

            if (userSelection.equals("x")) break;

            switch (userSelection) {
                case "l":
                    for(String name : NameRepository.findAll()) print(name);
                    break;

                case "s":
                    print(Integer.toString(NameRepository.getSize()));
                    break;

                case "a":
                    NameRepository.add(getStringFromUser("Enter full name: "));
                    break;

                case "u":
                    NameRepository.update(getStringFromUser("Old name: "), getStringFromUser("New name: "));
                    break;

                case "r":
                    NameRepository.remove(getStringFromUser("Enter full name: "));
                    break;

                case "ff":
                    for(String name : NameRepository.findByFirstName(getStringFromUser("Enter first name: "))) print(name);
                    break;

                case "fl":
                    for(String name : NameRepository.findByLastName(getStringFromUser("Enter last name: "))) print(name);
                    break;

                case "c":
                    NameRepository.clear();
                    break;

                default:
                    print("Invalid selection");
                    break;
            }
            getStringFromUser("\nPress Enter to continue");
        }
    }


    public static void print(String str) {
        System.out.println(str);
    }

    public static String getStringFromUser(String prompt) {
        Scanner scanner = new Scanner(System.in);

        System.out.print(prompt);
        return scanner.nextLine();
    }
}