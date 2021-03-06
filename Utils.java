package Assignment;

import java.io.*;
import java.io.File;
import java.io.IOException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class Utils {

    // File reader function
    public static ArrayList readFile(String fileName) throws Exception {
        ArrayList<String> returnItem = new ArrayList<>();

        if (fileName == null) {
            System.out.println("Please pass a ");
        } else if (!fileName.contains(".txt")) {
            System.out.println("Please provide a file with .txt extension");
        }
        // Try to read file
        try {
            File file = new File(fileName);

            BufferedReader br = new BufferedReader(new FileReader(file));
            returnItem = readAllLinesWithStream(br);

            return returnItem;

        } catch (Exception e) {
            System.out.println(
                    "Something went wrong while reading the file, kindly check the stacktrace to resolve the issue");
            e.printStackTrace();
            return returnItem;
        }
    }

    public static ArrayList<String> readAllLinesWithStream(BufferedReader reader) throws IOException {
        String read = null;
        ArrayList<String> list = new ArrayList<String>();

        while ((read = reader.readLine()) != null) {
            String[] splited = read.split("\n+");
            for (String part : splited) {
                list.add(part);
            }
        }
        return list;
    }

    public static String[] getStringArray(ArrayList<String> arr) {

        // declaration and initialise String Array
        String str[] = new String[arr.size()];

        // ArrayList to Array Conversion
        for (int j = 0; j < arr.size(); j++) {

            // Assign each value to String array
            str[j] = arr.get(j);
        }

        return str;
    }

    public static boolean inputValidator(Main.Validation data) {
        // System.out.println(data.getOption());

        if (data.getOption() < 1 || data.getOption() > data.getMaxValue()) {
            System.out.println("Please enter a correct option");
            return false;
        } else {
            return true;
        }
    }

    public static ArrayList filterByCategory(Object category, Restaurant[] obj) {
        ArrayList filtered_list = new ArrayList<Restaurant>();

        for (int i = 0; i < obj.length; i++) {
            // System.out.println(obj[i].getName() + " " + obj[i].getCategory());
            if (obj[i].getCategory().equals(category.toString())) {
                filtered_list.add(obj[i]);            }
        }
        return filtered_list;
    }

    public static ArrayList searchByName(String searchString, Restaurant[] obj) {
        ArrayList filtered_list = new ArrayList<Restaurant>();

        Pattern pattern = Pattern.compile(searchString, Pattern.CASE_INSENSITIVE);

        for (int i = 0; i < obj.length; i++) {
            Matcher matcher = pattern.matcher(obj[i].getName());
            boolean matchFound = matcher.find();
            if(matchFound) {
              filtered_list.add(obj[i]);
            }
        }
        return filtered_list;
    }
}