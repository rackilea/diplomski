import java.util.HashMap;

public class MorseCode {

    //Constants hold the accepted characters
    private final String alphabet = "abcdefghijklmnopqrstuvwxyz0123456789 ";
    private final String[] morse = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---",
        ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--..", ".----", "..---", "...--", "....-", ".....",
        "-....", "--...", "---..", "----.", "-----", "|"};

    //Maps map the code to text and text to code
    private HashMap<String, String> toText;
    private HashMap<String, String> toCode;

    //Problem: toText had text as keys. Keys should be used to identify the value your want to get.
    //Solution: swapped toText logic to toCode logic
    public MorseCode() {
        toText = new HashMap<>();
        toCode = new HashMap<>();
        char[] alphaArray = alphabet.toCharArray();
        for(int i = 0; i < morse.length; i++) {
            toText.put(morse[i], String.valueOf(alphaArray[i]));
            toCode.put(String.valueOf(alphaArray[i]), morse[i]);
        }
    }

    //Problem: kind of complicated logic. Was working, but did not need all that truncation
    //Solution: HashMap contains neat methods to work with keys - get(key) and containsKey(key)
    //In this solution, if the key is not found, we print the plain text character
    public String encode(String s) {
        s = s.toLowerCase();
        String encoded = "";
        for(int i = 0; i < s.length(); i++) {
            String c = String.valueOf(s.charAt(i));
            if (toCode.containsKey(c)) {
                encoded += toCode.get(c) + " ";
            } else {
                encoded += c;
            }
        }
        return encoded;
    }

    //Problem: logic was broken. Again, you are mapping the key to the value you want in toText, so use it.
    //Solution: Same logic than the encode method, but we had to strip off the spaces
    public String decode(String s) {
        String[] code = s.split(" ");
        String decoded = "";
        for(int i = 0; i < code.length; i++) {
            if (toText.containsKey(code[i])) {
                decoded += toText.get(code[i]);
            } else {
                decoded += "?";
            }
        }
        return decoded;
    }
}