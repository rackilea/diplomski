import java.util.Scanner;
import java.io.*;
class TestClass
{
    public static void main(String [] args) throws Exception
    {
        FileReader file = new FileReader("test.txt");
        Scanner sc = new Scanner(file);
        double sum = 0;
        while(sc.hasNext())
        {
            String line = sc.nextLine();
            // spit the line on - char
            String [] data = line.split("-");
            // Important : assuming price is always at index 2 parse and use value
             sum = sum + Double.parseDouble(data[2].trim());   
        }
        sc.close();
        System.out.println("Sum is "+sum);
    }
}