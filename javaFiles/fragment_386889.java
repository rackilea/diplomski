package stackquestions;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

 public class StackQuestions {


    public static void main(String[] args) {
       try{
            // Open the file that is the first
            // command line parameter

            FileInputStream fstream = new FileInputStream("file.txt");

            // Get the object of DataInputStream
            DataInputStream in = new DataInputStream(fstream);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String strLine;

            //Read File Line By Line
            while ((strLine = br.readLine()) != null)   {
                String[] data=strLine.split(",");


                for(int i=0;i<data.length;i++){
                    if(i!=1 && i!=2){
                         System.out.println (data[i]);
                    }

                }
                // Print the content on the console

            }

            //Close the input stream
            in.close();
        }catch (Exception e){//Catch exception if any
            System.err.println("Error: " + e.getMessage());
        }
}
}