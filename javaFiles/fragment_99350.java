import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Files {

    public void InfoReader(String fileName, String personName) {
        try {
            // Open the file that is the first command line parameter
            FileInputStream fstream = new FileInputStream(fileName);

            // Get the object of DataInputStream
            DataInputStream in = new DataInputStream(fstream);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));

            String line = null;

            //Loop until there are no more lines in the file
            while((line = br.readLine()) != null) {
                //Split the line to get 'personaName' and 'age'.
                String[] lineParts = line.split(" ");

                //Compare this line personName with the one provided
                if(lineParts[0].equals(personName)) {
                    //Print age
                    System.out.println(lineParts[1]);
                    br.close();
                    System.exit(0);
                }
            }

            br.close();
            //If we got here, it means that personName was not found in the file.
            System.out.println("that name doesn't exists");
        } catch (IOException e) {
            System.out.println(" there is an IO Error");
        }
    }
}