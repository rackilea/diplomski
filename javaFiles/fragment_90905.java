import java.util.LinkedHashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

public class PatternMatching {

  private final Map<String, Character> encodedWords = new LinkedHashMap<String, Character>();

  @Before
  public void init() {
    encodedWords.put("Angry", 'A');
    encodedWords.put("Smile", 'S');
    encodedWords.put("Frown", 'F');
  }

  public int findPatternIndex(final String[] array, final String pattern) {
    final StringBuffer encodedSequence = new StringBuffer();
    for (final String element : array) {
      encodedSequence.append(encodedWords.get(element));
    }
    return encodedSequence.toString().indexOf(pattern);
  }

  private void displayFindings(final int index) {
    if (index==-1) {
      System.out.println("No match found.");
    } else {
      System.out.println("First match against pattern found at index " + index);
    }
  }

  @Test
  public void shouldFindOneMatchThenNone() {
    final String[] array = {"Angry","Angry","Angry","Smile","Frown","Smile","Frown","Smile","Frown","Angry","Frown","Angry","Frown","Smile"};
    String pattern="SFSF";
    displayFindings(findPatternIndex(array, pattern));
    pattern="AAF";
    displayFindings(findPatternIndex(array, pattern));
  }

}