import java.util.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class ReplaceTokens {
public static void main(String[] args) {
    List<String> elements = Arrays.asList("ax", "bx", "dx", "c", "acc");
    final String patternStr = join(elements, "|"); //build string "ax|bx|dx|c|acc" 
    Pattern p = Pattern.compile(patternStr);
    Matcher m = p.matcher("ax 5 5 dx 3 acc c ax bx");
    StringBuffer sb = new StringBuffer();
    Random rand = new Random();
    while (m.find()){
        String randomSymbol = elements.get(rand.nextInt(elements.size()));
        m.appendReplacement(sb,randomSymbol);
    }
    m.appendTail(sb);
    System.out.println(sb);
}

/**
 * this method is only needed to generate the string ax|bx|dx|c|acc in a clean way....
 * @see org.apache.commons.lang.StringUtils.join    for a more common alternative...
 */
public static String join(List<String> s, String delimiter) {
    if (s.isEmpty()) return "";
    Iterator<String> iter = s.iterator();
    StringBuffer buffer = new StringBuffer(iter.next());
    while (iter.hasNext()) buffer.append(delimiter).append(iter.next());
    return buffer.toString();
}