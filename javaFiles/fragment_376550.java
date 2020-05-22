package binarysearch;

import java.io.*;
import java.util.Scanner;

/**
 *
 * @author Timothy
 */
public class BinarySearch {

    private static boolean write=false;

    public static void main(String[] args) throws IOException {

        String file_name = "C:\\Users\\Timothy\\Documents\\test.txt";
        String[] aryLines = {};        
        try {
            ReadFile file = new ReadFile(file_name);
            aryLines = file.OpenFile();

        } catch (IOException error) {
            System.out.println(error.getMessage());
        }

        String newName;

        Scanner in = new Scanner(System.in);
        System.out.println("Enter a name to compare to list: ");
        newName = in.nextLine();

        for (String name : aryLines) {
            if (name.equalsIgnoreCase(newName)) {
                System.out.println("This name has already been added");
                write = false;
                break;
            } else {
                write = true;
            }
        }
        if (write == true) {
            WriteFile data = new WriteFile(file_name, true);
            data.writeToFile("\n" + newName);
            System.out.println("New name added successfully");
         }
    }
}