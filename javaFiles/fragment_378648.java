import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Demo {
  public static void main(String[] args) throws FileNotFoundException {

    //call the function that calculates the output and give it the path of the textfile to be used
    System.out.println(getNrOfOnesBetweenString("enterPathToYourTextFileHere.txt"));

  }

  private static Integer getNrOfOnesBetweenString(String filePath) throws FileNotFoundException {

  //store whether we found a 1 in this block
  Boolean oneFoundInThisBlock = false ;
  //this is the counter for the output we want to return
  Integer numberOfBlocksWithOne = 0 ;
  //this is the string between which we want to search a 1
  String stringToSearch = "AAAAAAA";

  //read the file
  BufferedReader br = new BufferedReader(new FileReader(filePath));

  try {

    String line;

    //foreach line
    while ((line = br.readLine()) != null) {

      //check if this line contains the string to search for
      if(line.equals(stringToSearch)) {
        //if yes: start a new block
        if(oneFoundInThisBlock) {
          //if there was a 1 since the last occurrence of stringToSearch, increase the counter
          numberOfBlocksWithOne++;
        }
        //reset for next block
        oneFoundInThisBlock = false;
      }
      //see if this line has a 1
      if (line.contains("1")){
        oneFoundInThisBlock = true;
      }
    }

    // add one for the last block -> remove this if you only want to count 1 if they are BETWEEN two "AAAAAA" (in your example you also counted the last one after so not sure what you need)
    if(oneFoundInThisBlock){
      numberOfBlocksWithOne++;
    }
  } catch(IOException e){
    System.out.println("Could not read from file "+filePath);
  }
  return numberOfBlocksWithOne;
  }
}