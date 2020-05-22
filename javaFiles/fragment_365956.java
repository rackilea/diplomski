package so4038148;

import static org.junit.Assert.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;

public class MathExpr {

  private static final Pattern PAT_BEAUTIFY = Pattern.compile("(\\d+)(\\w)");

  /** The shortest code, but not the most efficient one. */
  public static String beautify1(String s) {
    return s.replaceAll("(\\d+)(\\w)", "$1*$2");
  }

  /** Still short, and doesn't need to compile the regex each time. */
  public static String beautify2(String s) {
    return PAT_BEAUTIFY.matcher(s).replaceAll("$1*$2");
  }

  /**
   * Use this when you have to do more complicated things with the captured
   * groups.
   */
  public static String beautify3(String s) {
    Matcher m = PAT_BEAUTIFY.matcher(s);
    if (!m.find()) {
      return s;
    }
    StringBuffer sb = new StringBuffer();
    do {
      m.appendReplacement(sb, m.group(1) + "*" + m.group(2));
    } while (m.find());
    m.appendTail(sb);
    return sb.toString();
  }

  @Test
  public void test() {
    assertEquals("20*a+4*y", beautify1("20a+4y"));
    assertSame("hello", beautify1("hello"));

    assertEquals("20*a+4*y", beautify2("20a+4y"));
    assertSame("hello", beautify2("hello"));

    assertEquals("20*a+4*y", beautify3("20a+4y"));
    assertSame("hello", beautify3("hello"));
  }
}