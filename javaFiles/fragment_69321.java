import java.io.*;
 import java.util.*;


 public class test{
    public static void main(String args[]) {
       File fin = new File ("matrix1.txt");

       Scanner sc = null;
       try {
           scanner = new Scanner(fin);
       }
       catch(FileNotFoundException e) {
          System.out.println("File does not exist...");
          return;
       }
       while (scanner.hasNextLine()){
       String line = scanner.nextLine();
       System.out.println(line);
       }
    }
 }