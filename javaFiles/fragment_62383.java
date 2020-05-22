package test;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class TestMain {

public static void main(String[] args) throws IOException {

String sourceFileName = "src/output/compare1.txt";
String comparingFileName = "src/output/compare2.txt";
String outputFileName = "src/output/output.txt";

System.out.println("Starting ...  ");



File file1 = new File(sourceFileName);
File file2 = new File(comparingFileName);
PrintWriter file3 = new PrintWriter(outputFileName);

String line1 = "";
String line2 = "";

Scanner scan1 = new Scanner(file1);
Scanner scan2;
while(scan1.hasNextLine()){
    line1 = scan1.nextLine();
    scan2 = new Scanner(file2);
    while(scan2.hasNextLine()){
        line2 = scan2.nextLine();
        System.out.println("Line 1: " + line1 + "\n" + "Line 2: " + line2);
        if(line1.equals(line2)){
            file3.println(line1);
        }
    }
    scan2.close();
}
file3.close();





// Comparer comparer = new Comparer(sourceFileName, comparingFileName, oFN);
// comparer.compare();


// CompareByScanner compareBYScanner = new CompareByScanner(sourceFileName, 
comparingFileName, outputFileName);
// compareBYScanner.compare();


}


}