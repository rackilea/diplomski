import java.util.ArrayList;
import java.util.List;

public class WordWrap {

  public static void main(String[] args) {
    String input = "This is a rather long address, somewhere in a small street in Barcelona";
    List<String> wrappedLines = wrap(input, 35);
    for (String line : wrappedLines) {
      System.out.println(line);
    }
  }

  private static List<String> wrap(String input, int maxLength) {
    String[] words = input.split(" ");
    List<String> lines = new ArrayList<String>();

    StringBuilder sb = new StringBuilder();
    for (String word : words) {
      if (sb.length() == 0) {
        // Note: Will not work if a *single* word already exceeds maxLength
        sb.append(word);
      } else if (sb.length() + word.length() < maxLength) {
        // Use < maxLength as we add +1 space.
        sb.append(" " + word);
      } else {
        // Line is full
        lines.add(sb.toString());
        // Restart
        sb = new StringBuilder(word);
      }
    }
    // Add the last line
    if (sb.length() > 0) {
      lines.add(sb.toString());
    }

    return lines;
  }
}