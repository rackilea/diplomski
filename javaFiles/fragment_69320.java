import java.io.*;
 import java.util.*;

public class test{
    public static void main(String args[]) throws FileNotFoundException {
    File fin = new File ("matrix1.txt");
    Scanner scanner = new Scanner(fin);
       while (scanner.hasNextLine()){
       String line = scanner.nextLine();
       System.out.println(line);
       }
    }
 }