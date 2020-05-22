import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class WordSplits {
    public static Map<String, List<String>> first2rest(List<String> wordList) {
        Map<String, List<String>> first2RestWords = new HashMap<String, List<String>>();
        for (String word : wordList) {
            // TODO Make it use Pattern. Sample demo. Get the first word of
            // every string.
            String splits[] = word.split("\\W");
            String firstWord = splits[0];
            List<String> restWords = first2RestWords.get(firstWord);
            if (restWords == null) {
                restWords = new ArrayList<String>();
            }
            restWords.add(word);
            // store the complete pattern nevertheless
            first2RestWords.put(firstWord, restWords);
        }

        return first2RestWords;
    }

    public static Map<String, List<Integer>> longestSubstring(String line,
            List<String> first, List<String> second) {
        Map<String, List<Integer>> occurences = new LinkedHashMap<String, List<Integer>>();
        Map<String, List<String>> first2RestWords = first2rest(first);
        Map<String, List<String>> second2RestWords = first2rest(second);

        Matcher wordMatcher = Pattern.compile("\\w+").matcher(line);
        for (int start = 0; start < line.length() && wordMatcher.find(start);) {

            String word = wordMatcher.group();

            String maxWordFirst = "", maxWordSecond = "";
            if (first2RestWords.containsKey(word)) {
                maxWordFirst = longestMatch(
                        line.substring(wordMatcher.start()),
                        first2RestWords.get(word));
            }
            if (second2RestWords.containsKey(word)) {
                maxWordSecond = longestMatch(
                        line.substring(wordMatcher.start()),
                        second2RestWords.get(word));

            }

            if (maxWordFirst.length() > 0 || maxWordSecond.length() > 0) {
                if (maxWordFirst.equals(maxWordSecond)) {
                    System.out.println("Belongs to both the lists : " + maxWordFirst);
                } else {
                    if (maxWordFirst.length() > maxWordSecond.length()) {
                        System.out.println("Belongs to first list:  " + maxWordFirst);
                    } else if (maxWordSecond.length() > maxWordFirst.length()) {
                        System.out.println("Belongs to second list: " + maxWordSecond);
                    }
                }
            } else {
                System.out.println(word + " does not belong to any list");
            }
            // Take some action
            start = wordMatcher.start() + Math.max(maxWordFirst.length(), maxWordSecond.length()) + 1;
            start = Math.max(wordMatcher.end(), start);
        }

        return occurences;
    }

    public static String longestMatch(String line, List<String> wordList) {
        String maxWord = "";
        // poor way to compare
        for (String word : wordList) {
            if (line.startsWith(word) && word.length() > maxWord.length()) {
                maxWord = word;
            }
        }

        return maxWord;
    }

    public static void main(String[] args) {
        longestSubstring("artificial intelligence is cool. bat.",
                Arrays.asList("dog", "cow", "dog", "artificial intelligence", "bat"),
                Arrays.asList("artificial", "hound", "cool", "bat", "dog hound"));
    }
}