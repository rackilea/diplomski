import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatchStringsInQuote {

  private String [] eekWords = { "fear", "Little", "death", "gone", "Fear is the mind-killer"};

  private void searchQuote(String quote) {
      eekWords = Arrays.stream(eekWords).map(w -> w.toLowerCase()).toArray(String[]::new);
      quote = quote.toLowerCase();
      int counter = 0;
      for(int i = 0; i < eekWords.length; i++) {
          Pattern pattern = Pattern.compile(eekWords[i]);
          Matcher matcher = pattern.matcher(quote);
          while (matcher.find()) {
              counter ++;
              System.out.println(eekWords[i]);
          }
      }
      System.out.println("Found " + counter + " matches.");
  }

  public static void main(String [] args) {
      MatchStringsInQuote matchStringsInQuote = new MatchStringsInQuote();
      String Quote = "I must not fear. Fear is the mind-killer. Fear is the little-death that brings total obliteration. I will face my fear. I will permit it to pass over me and through me. And when it has gone past I will turn the inner eye to see its path. Where the fear has gone there will be nothing. Only I will remain.";
      matchStringsInQuote.searchQuote(Quote);
  }
}