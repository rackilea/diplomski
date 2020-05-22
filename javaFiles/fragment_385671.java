import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class ParseFileName {
  public static void main(String[] args) throws IOException {
    Scanner in = null;
    try {
      in = new Scanner(new File("dates.txt"));
    } catch (FileNotFoundException exception) {
      System.err.println("failed to open dates.txt");
      System.exit(1);
    }
    while (in.hasNextLine()) {
      String line = in.nextLine();
      line = line.replace(".", "");
      line = line.replace(",", "");

      StringTokenizer st = new StringTokenizer(line);
      String strMonth = st.nextToken();
      String strDay = st.nextToken();
      String strYear = st.nextToken();

      Integer day = Integer.parseInt(strDay);
      Integer year = Integer.parseInt(strYear);
      //...
    }
  }