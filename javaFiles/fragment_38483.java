import java.io.*;
class FileRead {
    public static void main(String args[]) {
        try{
            BufferedReader br = new BufferedReader(new FileReader("textfile.txt"));
            String strLine;
            //Read File Line By Line
            while ((strLine = br.readLine()) != null)   {
               // Print the content on the console
               System.out.println (strLine);
            }
            //Close the input stream
            br.close();
         } catch (Exception e){//Catch exception if any
             System.err.println("Error: " + e.getMessage());
         }
     }
 }


import java.io.*;
class FileWrite {
    public static void main(String args[]) {
        String var = "var";
        try {
            // Create file 
            FileWriter fstream = new FileWriter("out.txt");
            BufferedWriter out = new BufferedWriter(fstream);
            out.write(var);
            //Close the output stream
            out.close();
        } catch (Exception e){//Catch exception if any
            System.err.println("Error: " + e.getMessage());
        }
    }
}