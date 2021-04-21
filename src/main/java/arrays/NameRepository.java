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

            newNames[newNames.length - 1] = fullName;
            names = newNames;

            return true;
        }

        return false;
    }

    public static String find(final String fullName) {
        for (String name : names) {
            if (name.equals(fullName)) {
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
            if (names[i].equals(original)) {
                names[i] = updatedName;
                return true;
            }
        }
        return false;
    }

    public static String[] findByFirstName(final String firstName) {
        String[] matches = new String[0];

        for (String name : names) {
            if (name.split(" ")[0].equals(firstName)) {
                matches = Arrays.copyOf(matches, matches.length + 1);
                matches[matches.length - 1] = name;
            }
        }

        return matches;
    }

    public static String[] findByLastName(final String lastName) {
        String[] matches = new String[0];

        for (String name : names) {
            if (name.split(" ")[1].equals(lastName)) {
                matches = Arrays.copyOf(matches, matches.length + 1);
                matches[matches.length - 1] = name;
            }
        }

        return matches;
    }

    public static boolean remove(final String fullName) {
        String[] newNames = new String[0];

        for (String name : names) {
            if (!name.equals(fullName)) {
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
}
