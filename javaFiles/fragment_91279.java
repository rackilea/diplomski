import java.io.*;
import java.util.*;

public class Trying4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the number of words: ");
        int numWords = in.nextInt();
        in.nextLine(); // consume the new-line character after the number
        for(int i = 0; i < numWords; i++) {
            char[] word = in.nextLine().toCharArray();
            display(word);
        }
    }
    public static void display(char[] word) {
        for(int i = 0; i < word.length; i += 2) {
            System.out.print(word[i]);
        }
        System.out.print(" ");
        for(int i = 1; i < word.length; j += 2) {
            System.out.print(word[i]);
        }
        System.out.println();
    }
}