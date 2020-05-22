import java.io.*;
import java.util.*;
public class projectFour
{
    public static int [] global_numbers;
    public static void main (String[] args)
    {
        read_file();
        print_numbers(global_numbers);
    }
    public static void read_file()
    {
        try
        {
            File file = new File("randomNumbers.txt"); 
            Scanner scan = new Scanner(file);
            int amountOfNumbersInFile = convertingStringToInt(scan.nextLine());
            global_numbers = new int[amountOfNumbersInFile];
            for (int index = 0; index < amountOfNumbersInFile; index++) 
            {
                String line = scan.nextLine(); 
                global_numbers [index] = convertingStringToInt(line); 
            }      
        } catch (IOException ex) {
           ex.printStackTrace();
        }
    }
    public static int convertingStringToInt(String numbers)
    {  
        try {
            return Integer.parseInt(numbers.trim());
        } catch(NumberFormatException n) {
            return -460;
        }         
    }
    public static void print_numbers(int [] numbers) 
    {
      for(int i = 0; i < numbers.length; i++)
            System.out.println(numbers[i]); 
    }
}