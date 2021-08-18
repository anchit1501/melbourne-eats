package Assignment;

import java.io.*;
import java.io.File;
import java.io.IOException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;

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

    public static String[] GetStringArray(ArrayList<String> arr)
    {

        // declaration and initialise String Array
        String str[] = new String[arr.size()];

        // ArrayList to Array Conversion
        for (int j = 0; j < arr.size(); j++) {

            // Assign each value to String array
            str[j] = arr.get(j);
        }

        return str;
    }

    public static boolean inputValidator(Main.Validation data){
//        System.out.println(data.getOption());

        if(data.getOption()<1 || data.getOption()>data.getMaxValue()){
            System.out.println("Please enter a correct option");
            return false;
        }
        else {
            return true;
        }
    }

    public static HashMap<Integer, Restaurant> filter(Object category, Restaurant[] obj){
        HashMap<Integer,Restaurant> filtered_list = new HashMap<>();
        int j =0;
        for (int i = 0; i <  obj.length; i++) {
//            System.out.println(obj[i].getName() + " " + obj[i].getCategory());
            if (obj[i].getCategory().equals(category.toString())) {
                filtered_list.put(j,obj[i]);
                j++;
//                System.out.println("match----"+obj[i].getName());
            }
        }
        return filtered_list;
    }
}