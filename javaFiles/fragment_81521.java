import java.io.InputStream;
import java.util.Arrays;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class Q19505617 {
  public static void main(String[] args) {
    DatosPalabras datos = new DatosPalabras("words.txt");
    JOptionPane.showMessageDialog(null, datos);
    datos.sort();
    JOptionPane.showMessageDialog(null, datos);
  }
}

class DatosPalabras {
  private String[] lines;

  public DatosPalabras(String filename) {
    lines = new String[1];
    int lineCounter = 0;
    InputStream in = Q19505617.class.getResourceAsStream(filename);
    Scanner scanner = new Scanner(in);
    while (scanner.hasNextLine()) {
      String line = scanner.nextLine();
      System.out.println(line);
      if(lineCounter == lines.length) {
        lines = Arrays.copyOf(lines, lines.length * 2);
      }
      lines[lineCounter] = line;
      lineCounter++;
    }
  }

  public void sort() {
    // put your real sort algorithm here. until then use this:
  }

  public String toString() {
    StringBuilder b = new StringBuilder();
    for (String line : lines) {
      b.append(line).append("\n");
    }
    return b.toString();
  }
}