import java.io.*;
import java.util.Scanner;

class hangman {
public static void main(String args[]){

    int counter = 6;
    String m = "ashish";
    char mj[] = m.toCharArray();
    char correct[] = new char[mj.length];


    //for printing the puzzle 
    for(int j=0;j<m.length();j++) {
        if(mj[j]%3==0) {   
            System.out.print(" "+mj[j]);
            correct[j] = mj[j];
        }
        else {
            System.out.print(" ___ ");
        }
    }    

    System.out.println();

    //taking the input from user
    Scanner scanner=new Scanner(System.in);

    do {
        char c=scanner.next().charAt(0);

        System.out.println(c+"-----scanning complete");
        for(int i=0;i<m.length();i++) {
            if(c==mj[i]) {
                correct[i] = c;
                counter--;
            }
            // This is the default value of a char in Java.
            if (correct[i] == '\u0000') {
                System.out.print(" ___ "); 
            } else {
                System.out.print(correct[i]);
            }
        }

    } while(counter != 0);
  }
}