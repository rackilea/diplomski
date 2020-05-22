import java.util.HashMap;
import java.util.Map;

public class MorseFun {
   public static final String[] LETTER_CODES = { ".-", "-...", "-.-.", "-..",
         ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.",
         "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--",
         "-..-", "-.--", "--.." };
   public static final String[] NUMBER_CODES = { "-----", ".----", "..---",
         "...--", ".----", ".....", "-....", "--...", "---..", "----." };

   private static Map<Character, String> charToCodeMap = new HashMap<>();
   private static Map<String, Character> codeToCharMap = new HashMap<>();

   public static void main(String[] args) {
      for (int i = 0; i < LETTER_CODES.length; i++) {
         char c = (char) ('a' + i);
         String s = LETTER_CODES[i];
         charToCodeMap.put(c, s);
         codeToCharMap.put(s, c);
      }

      for (int i = 0; i < NUMBER_CODES.length; i++) {
         char c = (char) ('0' + i);
         String s = LETTER_CODES[i];
         charToCodeMap.put(c, s);
         codeToCharMap.put(s, c);
      }



   }
}