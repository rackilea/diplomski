import java.util.regex.*;

public final class Replacer {

  //aText: "(hi|hello) my name is (Bob|Robert). Today is a (good|great|wonderful) day."
  //returns: "hello my name is Bob. Today is a wonderful day."
  public static String getEditedText(String aText){
    StringBuffer result = new StringBuffer();
    Matcher matcher = fINITIAL_A.matcher(aText);
    while ( matcher.find() ) {
      matcher.appendReplacement(result, getReplacement(matcher));
    }
    matcher.appendTail(result);
    return result.toString();
  }

  private static final Pattern fINITIAL_A = Pattern.compile(
    "\\\((\\\w+(\\\|\w+)*)\\\)",
    Pattern.CASE_INSENSITIVE
  );

  //aMatcher.group(1): "hi|hello"
  //words: ["hi", "hello"]
  //returns: "hello"
  private static String getReplacement(Matcher aMatcher){
    var words = aMatcher.group(1).split('|');
    var index = randomNumber(0, words.length);
    return words[index];
  }

}