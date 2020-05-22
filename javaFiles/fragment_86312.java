import java.io.*;

public class ReadFile {

    //create method to split text file, call this from main
    public static void splitIt(String toTest)
    {
        String[] result = toTest.split(" ");

        for (String piece:result)
        {
            //loop through the array and print each piece
            System.out.println(piece);

        }
    }


    public static void main(String[] args) {

        //create readfile method
        try
        {
            File test = new File("C:\\final\\test.txt");
            FileReader fileReader = new FileReader(test);
            BufferedReader reader = new BufferedReader(fileReader);

            String line = null;

            //While there are still lines to be read, read and print them
            while((line = reader.readLine()) != null)
            {
                System.out.println(line); // print the current line
                splitIt(line);
            }

            reader.close();
        }

        //Catch those errors!
        catch (Exception ex)
        {
            ex.printStackTrace();
        }

    }

}