import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.*;
import java.util.Random;

public class ProChallenge10 {

public static void main(String[]args) throws IOException{

    int integer =0; //Integer enter by the user.

    boolean signal = false; // To end the loop.

    Scanner keyboard = new Scanner(System.in);

    List<Integer> listofInt = new ArrayList<Integer>();// Array List for your integers

    //Created the file for the integers entered. 
    PrintWriter outputFile = new PrintWriter("ProChallenge10.txt"); 

    //Let the user enter a series of numbers.
    while(signal == false){

        System.out.println("Enter an integer");
        integer = keyboard.nextInt();

        listofInt.add(integer);// adding of int to list


    //To end the program.
    if(integer == -99){
        listofInt.sort(null);// sort the list
        for(int x=0;x<listofInt.size();x++){
            outputFile.println(listofInt.get(x));//Printing of list to text file
        }
        signal = true;
        //Close the outputFile.
        outputFile.close();
        } 
    }

     //Open the file and read input from the file.
     File file = new File("ProChallenge10.txt");
     Scanner inputFile = new Scanner(file);

     //Read all of the values from the file and display their numbers. 
     while(inputFile.hasNext()){

        int number = inputFile.nextInt();

       }
     //Close the InputFile.
     inputFile.close();
}