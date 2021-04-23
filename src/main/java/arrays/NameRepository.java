package arrays;

import java.util.Arrays;

public class NameRepository {

    private static String[] names = new String[0];

    public static int getSize() {

        return names.length;
    }

    public static void clear() {
        names = new String[0];
    }

    public static boolean add(final String fullName) {
        if (find(fullName) == null) {
            String[] newNames = Arrays.copyOf(names, names.length + 1);

            newNames[newNames.length - 1] = sanitizeName(fullName);
            Arrays.sort(newNames);
            names = newNames;

            return true;
        }

        return false;
    }

    public static String find(final String fullName) {
        for (String name : names) {
            if (name.equalsIgnoreCase(fullName)) {
                return name;
            }
        }
        return null;
    }

    public static String[] findAll() {
        return Arrays.copyOf(names, names.length);
    }

    public static boolean update(final String original, final String updatedName) {
        if (find(updatedName) != null) {
            return false;
        }
        for (int i = 0; i < getSize(); i++) {
            if (names[i].equalsIgnoreCase(original)) {
                names[i] = sanitizeName(updatedName);
                return true;
            }
        }
        return false;
    }

    public static String[] findByFirstName(final String firstName) {
        String[] matches = new String[0];

        for (String name : names) {
            if (name.split(" ")[0].equalsIgnoreCase(firstName)) {
                matches = Arrays.copyOf(matches, matches.length + 1);
                matches[matches.length - 1] = name;
            }
        }

        return matches;
    }

    public static String[] findByLastName(final String lastName) {
        String[] matches = new String[0];

        for (String name : names) {
            if (name.split(" ")[1].equalsIgnoreCase(lastName)) {
                matches = Arrays.copyOf(matches, matches.length + 1);
                matches[matches.length - 1] = name;
            }
        }

        return matches;
    }

    public static boolean remove(final String fullName) {
        String[] newNames = new String[0];

        for (String name : names) {
            if (!name.equalsIgnoreCase(fullName)) {
                newNames = Arrays.copyOf(newNames, newNames.length + 1);
                newNames[newNames.length - 1] = name;
            }
        }

        if (names.length != newNames.length) {
            names = newNames;
            return true;
        }

        return false;
    }

    private static String sanitizeName(String str) {
        char[] capStr = str.trim().toCharArray();

        for (int i = 0; i < capStr.length; i++) {
            if (i == 0 || capStr[i - 1] == ' ') {
                capStr[i] = Character.toUpperCase(capStr[i]);
            } else {
                capStr[i] = Character.toLowerCase(capStr[i]);
            }
        }

        return new String(capStr);
    }
}
