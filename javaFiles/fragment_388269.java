import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Based on your request and keeping this dead simple this an example of reading
 * a description file using CSV  (comman delimited)
 *
 * Contents of the description.txt (in this example its in the same path)
 *
 *    Game 1, Description 1
 *    Game 2, Description 2
 *    Game 3, Description 3
 *    ....
 *    Game N, Description N
 *
 * You may want to investigate storage in a XML file or JSON file or use of database
 *
 */
 public class TestReader {

   public static void main(String[] args) {
     try {
        System.out.println("File CSV Reader Test, you should see outpout of the contents in description.txt:");

        Scanner scan = new Scanner(new File("description.txt"));
        while(scan.hasNextLine()){
          String line = scan.nextLine();

          // For testing, output to console each line
          System.out.println(line);

          // At this point you can do whatever with the line
          // Store it into a data object and added to a collection     like an ArrayList, 2d array...etc

         // Split the comma delimited string into individual values into an array
         // String[] lineValues = line.split(",");

      }

    } catch (Exception e){
      System.out.println(e.getMessage());
    }
  }
 }