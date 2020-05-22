import java.io.FileWriter;
import java.io.IOException;

import com.opencsv.CSVWriter;

public class OpenCSVTest {

    public static void main(String[] args) {
        CSVProcessor process = new CSVProcessor(); 

        String[] entries = new String[]{"1","2","3","x"}; 

        //assume each loop is when you get updated entries
        for(int i = 0; i < 5; i++) {
            //store to the file 
            process.storeUpdatedValues(entries);

            //change the vaues to simulate update in x,y,z
            entries[0] = entries[0] + 5; 
            entries[1] = entries[1] + 10; 
            entries[2] = entries[2] + 3; 
            entries[3] = entries[3] + "i:" + i; 
        }
    }
}

class CSVProcessor {
    public void storeUpdatedValues(String[] entries) {
        CSVWriter writer;
        try {
             /*
              *  First arg to CSVWriter is FileWriter that references your file in the disk
              *  Second arg to the CSVWriter is the delimiter, can be comma, tab, etc. 
              *  First arg to FileWriter is location of your file to write to 
              *  Second arg to FileWriter is a flag stating that if file found then append to it 
              */
             writer = new CSVWriter(new FileWriter("C:\\test_java\\yourfile.csv", true), ',');

            // feed in your array - you don't need to loop through the items of array
             writer.writeNext(entries);

             // close the writer.
             writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}