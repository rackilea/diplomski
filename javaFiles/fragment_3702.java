package Jone;
import java.io.*;
import java.util.*;


public class Jone  {
    public static void main (String [] args)throws IOException{
       try{
    int rows = 0;
    Scanner file = new Scanner (new File("data.txt"));
    while (file.hasNextLine())
    {
        rows++;
        file.nextLine();
    }

    file = new Scanner (new File("data.txt"));
    System.out.println(rows);
    Object[][] data = new Object[rows][5];
    for(int i = 0;i<rows;i++)
    {
        String str = file.nextLine();
        String[] tokens= str.split(",");
        for (int j = 0;j<5;j++)
        {
            data[i][j] = tokens[j]; 
            System.out.print(data[i][j]);
            System.out.print(" ");
        }         
    }
    file.close();
            }
    catch(Exception e)
    {
        e.printStackTrace();
    }

}