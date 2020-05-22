import java.util.*;
import java.io.*;

public class Program2 {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        String input = kb.nextLine();
        System.out.println(input);

        while(!input.equals("#")) {
            //                    VVV
            String[] data = input.split("[^\\d]+");
            int sum = 0;

            for(int i = 0; i < data.length; i++) {
                if (!data[i].equals("")) {
                    int dataInt = Integer.parseInt(data[i]);
                    sum = sum + dataInt;
                }
            }

            System.out.println(sum);
            input = kb.nextLine();
        }
    } //main
} // class Program2