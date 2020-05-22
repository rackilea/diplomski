package so7783938;

import static org.junit.Assert.assertEquals;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;

public class RegexFailureTest {

  public static int firstFailurePoint(Pattern regex, String str) {
    for (int i = 0; i <= str.length(); i++) {
      Matcher m = regex.matcher(str.substring(0, i));
      if (!m.matches() && !m.hitEnd()) {
        return i - 1;
      }
    }
    if (regex.matcher(str).matches()) {
      return -1;
    } else {
      return str.length();
    }
  }

  @Test
  public void testSimple() {
    Pattern abc = Pattern.compile("abc");
    assertEquals(0, firstFailurePoint(abc, ""));
    assertEquals(1, firstFailurePoint(abc, "a"));
    assertEquals(2, firstFailurePoint(abc, "ab"));
    assertEquals(-1, firstFailurePoint(abc, "abc"));
    assertEquals(3, firstFailurePoint(abc, "abcd"));
    assertEquals(3, firstFailurePoint(abc, "abcdefghi"));
    assertEquals(1, firstFailurePoint(abc, "aaa"));
    assertEquals(2, firstFailurePoint(abc, "abb"));
  }

  @Test
  public void testAlternative() {
    Pattern regex = Pattern.compile("hello|world");
    assertEquals(0, firstFailurePoint(regex, "x"));
    assertEquals(-1, firstFailurePoint(regex, "hello"));
    assertEquals(-1, firstFailurePoint(regex, "world"));
    assertEquals(3, firstFailurePoint(regex, "hel"));
    assertEquals(5, firstFailurePoint(regex, "hello kitty"));
    assertEquals(3, firstFailurePoint(regex, "help me"));
    assertEquals(3, firstFailurePoint(regex, "worse is better"));
  }

  @Test
  public void testExample() {
    Pattern regex = Pattern.compile("^\\d{9}[VX]$");
    assertEquals(-1, firstFailurePoint(regex, "547812375X"));
    assertEquals(3, firstFailurePoint(regex, "547A12375X"));
  }

}