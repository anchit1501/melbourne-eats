package Assignment;

import java.io.*;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Collectors;

public final class Utils {

    // File reader function
    public static ArrayList readFile(String fileName) throws Exception {
    ArrayList<String> returnItem = new ArrayList<>();

        if (fileName == null) {
            System.out.println("Please pass a ");
        }
        else if(!fileName.contains(".txt")){
            System.out.println("Please provide a file with .txt extension");
        }
        // Try to read file
        try {
            File file = new File(fileName);

            BufferedReader br = new BufferedReader(new FileReader(file));
            returnItem.add(readAllLinesWithStream(br));
            System.out.println(returnItem);

//            return br.toString();
            return returnItem;

        } catch (Exception e) {
            System.out.println(
                    "Something went wrong while reading the file, kindly check the stacktrace to resolve the issue");
            e.printStackTrace();
//            return e.toString();
            return returnItem;
        }
    }

    public static String readAllLinesWithStream(BufferedReader reader) {
        return reader.lines()
                .collect(Collectors.joining(System.lineSeparator()));
    }

}