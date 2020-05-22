package fileread;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;


public class FileRead {

   private static HashMap<Integer, ArrayList<Double>> map = new HashMap<>();
   private static BufferedReader reader;

   public static void main(String[] args) {
      try
      {
          reader = new BufferedReader(new FileReader("input"));
          //or reader = new BufferedReader(new FileReader("C:\\full-path-to-your-file));
          String line;
          while((line = reader.readLine()) != null)
         {
            String[] tokens = line.split(" ");
            Integer i;
            Double d;
            ArrayList<Double> list = new ArrayList<>();
            i = Integer.valueOf(tokens[0]);

            for(int j = 1; j < tokens.length; j++)
                list.add(Double.valueOf(tokens[j]));
            map.put(i, list);
        }
    }catch(IOException ex)
    {
        //break execution
    }finally
    {
        if(reader != null)
            try 
            {
                reader.close();
            }catch (IOException ex) {
                //don't break :)
            }
    }

    for(Integer i : map.keySet())
    {
        ArrayList<Double> l = map.get(i);
        System.out.print("Line " + i + ": ");
        for(Double d: l)
            System.out.print(d + " ");
        System.out.println();
    }

   }    
 }