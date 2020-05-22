import java.io.*;
import java.util.*;

public class DATA {
     public static void main(String[] args) throws FileNotFoundException {
        PrintWriter writerInt = new PrintWriter(new File("sortedInt.txt"));
        PrintWriter writerDou = new PrintWriter(new File("sortedDou.txt"));
        Scanner reader = new Scanner(new File("raw.txt"));
        int temp = 0, countInt = 1, countDou = 1;
        while (reader.hasNext()) {
            String next = reader.next();
            try{
                temp=Integer.parseInt(next);
                writerInt.print(temp+" ");
                if (countInt % 4 == 0) 
                    writerInt.println(); 
                countInt++;    
            }catch(NumberFormatException e){
                try{
                    writerDou.print(Double.parseDouble(next)+" ");
                    if (countDou % 4 == 0) 
                        writerDou.println(); 
                    countDou++;   
                }catch(NumberFormatException f){
                    System.out.println("Not a number");
                }
            }

        }
        writerInt.close();
        writerDou.close();
        reader.close();
    }
}