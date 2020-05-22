import java.io.*;

public class ParseLines {
  public static void main(String[] args) {
    try {
      FileInputStream fs = new FileInputStream("input.txt");
      BufferedReader reader =
        new BufferedReader(new InputStreamReader(new DataInputStream(fs)));

      String line;
      double collect[] = {0.0, 0.0, 0.0, 0.0};
      int lines = 0;
      while ((line = reader.readLine()) != null) {
        String[] parts = line.split(",");
        if (parts.length == 5) {
          int avg = 0;
          boolean skip = false;
          for (int i = 1; i < 5; i++) {
            String part = parts[i].trim();

            try {
              int num = Integer.valueOf(part);
              avg += num;
              collect[i - 1] += (double) num;
            }
            catch (NumberFormatException nexp) {
              System.err.println("Input '" + part +
                                 "' not a number on line: " + line);
              skip = true;
              break;
            }
          }

          if (skip) continue;

          avg /= 4;
          lines++;                    

          System.out.println("Last name: " + parts[0].split(" ")[1] +
                           ", Avg.: " + avg);
        }
        else {
          System.err.println("Ignored line: " + line);
        }
      }

      for (int i = 0; i < 4; i++) {
        collect[i] /= (double) lines;
        System.out.println("Average of column " + (i + 1) + ": " +
                           collect[i]);
      }

      reader.close();
    } catch (Exception e){
      System.err.println("Error: " + e.getMessage());
    }    
  }
}