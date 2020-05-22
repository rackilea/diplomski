import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.sun.xml.internal.ws.util.StringUtils;

/**
 * Created by IntelliJ IDEA.
 * User: fkhan
 * Date: Aug 31, 2012
 * Time: 1:36:45 PM
 * To change this template use File | Settings | File Templates.
 */


public class TestClass {


    public static void main(String args[]) throws Exception {

        //String text = "INCLUDES(ABC) EXCLUDES(ABC) EXCLUDES(ABC) INCLUDES(EFG) INCLUDES(IJK)";
        String text = "EXCLUDES(ABC) EXCLUDES(ABC) INCLUDES(BMG) INCLUDES(EFG) INCLUDES(IJK)";
        List<String> matchedList = findMatchPhrase("INCLUDES", text);
        String query = combinePhrase(text, "INCLUDES", matchedList);
        System.out.println(query);


    }

    /**
     * This method takes query combine and & multiple phrases
     * @param expression
     * @param keyword
     * @param matchedItemList
     * @return
     */
    private static String combinePhrase(String expression, String keyword, List<String> matchedItemList) {

        //if only one phrase found return value
        if(matchedItemList.isEmpty() || matchedItemList.size() ==1){
            return expression;
        }

        //do not remove first match
        String matchedItem = null;
        for (int index = 1; index < matchedItemList.size(); index++) {

            matchedItem = matchedItemList.get(index);

            //remove match items from string other then first match
            expression = expression.replace(matchedItem, "");
        }

        StringBuffer textBuffer = new StringBuffer(expression);

        //combine other matched strings in first matched item
        StringBuffer combineStrBuf = new StringBuffer();
        if (matchedItemList.size() > 1) {

            for (int index = 1; index < matchedItemList.size(); index++) {
                String str = matchedItemList.get(index);
                combineStrBuf.append((parseValue(keyword, str)));
                combineStrBuf.append(" & ");

            }
            combineStrBuf.delete(combineStrBuf.lastIndexOf(" & "), combineStrBuf.length());
        }

        // Inject created phrase into first phrase
        //append in existing phrase
        return injectInPhrase(keyword, textBuffer, combineStrBuf.toString());
    }

    /**
     *
     * @param keyword
     * @param textBuffer
     * @param injectStr
     */
    private static String injectInPhrase(String keyword, StringBuffer textBuffer, String injectStr) {
        Matcher matcher = getMatcher(textBuffer.toString());
        while (matcher.find()) {

            String subStr = matcher.group();
            if (subStr.startsWith(keyword)) {
                textBuffer.insert(matcher.end()-1, " & ".concat(injectStr));
                break;
            }

        }

       return textBuffer.toString();
    }

    /**
     * @param expression
     * @param keyword
     * @return
     */
    private static String parseValue(String keyword, String expression) {

        String parsStr = "";
        if (expression.indexOf(keyword) > -1) {
            parsStr = expression.replace(keyword, "").replace("(", "").replace(")", "");
        }

        return parsStr;
    }


    /**
     * This method creates matcher object
     * and return for further processing
     * @param expression
     * @return
     */
    private static Matcher getMatcher(String expression){
        String patternString = "(\\w+)\\((.*?)\\)";
        Pattern pattern = Pattern.compile(patternString);
        return pattern.matcher(expression);
    }
    /**
     * This method find find matched items by keyword
     * and return as list
     * @param keyword
     * @param expression
     * @return
     */
    private static List<String> findMatchPhrase(String keyword, String expression) {
        List<String> matchList = new ArrayList<String>(3);

        keyword = StringUtils.capitalize(keyword);
        Matcher matcher = getMatcher(expression);

        while (matcher.find()) {

            String subStr = matcher.group();
            if (subStr.startsWith(keyword)) {
                matchList.add(subStr);
            }
        }

        return matchList;
    }



}