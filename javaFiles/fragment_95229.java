import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class ReadTemps {

  public static void main(String[] args) throws IOException {
    // TODO code application logic here

    // // read KeyWestTemp.txt

    // create token1

    // for-each loop for calculating heat index of May - October

    // create Scanner inFile1
    Scanner inFile1 = new Scanner(new File("KeyWestTemp.txt")).useDelimiter(",\\s*");


    // Original answer used LinkedList, but probably preferable to use ArrayList in most cases
    // List<Float> temps = new LinkedList<Float>();
    List<Float> temps = new ArrayList<Float>();

    // while loop
    while (inFile1.hasNext()) {
      // find next line
      float token1 = inFile1.nextFloat();
      temps.add(token1);
    }
    inFile1.close();

    Float[] tempsArray = temps.toArray(new Float[0]);

    for (Float s : tempsArray) {
      System.out.println(s);
    }
  }
}