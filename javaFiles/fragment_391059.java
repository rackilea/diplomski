import java.util.regex.*;

String yourString = "(The farmer's daughter) went to the supermarket";

/* The regex syntax is basically identical to Ruby, except that you need
 * to specify your regex as a normal string literal, and therefore you need to 
 * double up on your backslashes. The other differences between my regex and 
 * yours are all things that I think you need to change about the Ruby version
 * as well. */
Pattern p = Pattern.compile("[\\w']+");
Matcher m = p.matcher(yourString);
List<String> words = new Vector<String>();
while (m.find()) {
   words.add(m.group());
}