import java.util.HashMap;
import java.util.Map;

class MyString {

    String string;
    static final Map<Character, Character> toLowerCaseMap, toUpperCaseMap;

    static {
        toLowerCaseMap = new HashMap<>();
        toLowerCaseMap.put('I', '|');

        toUpperCaseMap = new HashMap<>();
        toUpperCaseMap.put('b', 'P');
    }

    MyString(String string) {

        this.string = string;
    }

    String toLowerCase() {

        char[] chars = string.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            chars[i] = toLowerCaseMap.containsKey(c) ? toLowerCaseMap.get(c) : Character.toLowerCase(c);
        }

        return new String(chars);
    }

    String toUpperCase() {

        char[] chars = string.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            chars[i] = toUpperCaseMap.containsKey(c) ? toUpperCaseMap.get(c) : Character.toUpperCase(c);
        }

        return new String(chars);
    }
}