import java.util.*;
import java.util.regex.*;
import java.lang.*;
import java.io.*;

class Ideone
{
    public static void main (String[] args) throws java.lang.Exception
    {
        String tree = "(30:0.07,(1:0.06,2:0.76))";
        HashMap<String, String> h = new HashMap<String, String>();
        h.put("(1:" , "(30:");
        h.put(",1:" , ",30:");
        h.put("(30:" , "(6:");
        h.put(",30:" , ",6:");
        System.out.println(convertTree(tree, h));

    }
    private static String convertTree(String treeOld, HashMap<String, String> conv) {
        Pattern pattern = Pattern.compile("[,(]\\d+:");  // Init the regex
        Matcher m = pattern.matcher(treeOld);            // Init the matcher
        StringBuffer result = new StringBuffer();        // Declare the string buffer (can be replaced with a string builder)
        while (m.find()) {                               // Iterate through matches
            if (conv.containsKey(m.group(0))) {          // Check if the key exists
                m.appendReplacement(result, conv.get(m.group(0))); // If yes, use the HashMap value
            }
            else {
                m.appendReplacement(result, m.group(0));  // Else, just reinsert the match value
            }
        }
        m.appendTail(result);        // Append what remains to the result
        return result.toString();

    }
}