public class TestType {

public static void main(String[] args) {

    /*
     * Create a Map of replacements
     */
    Map<Character, String> keyMap = new HashMap<Character, String>();
    keyMap.put('a', "12");  keyMap.put('b', "13");
    keyMap.put('c', "14");  keyMap.put('d', "15");
    keyMap.put('e', "16");  keyMap.put('f', "17");
    keyMap.put('g', "18");  keyMap.put('h', "19");
    //Add more key-values for all letter support


    String plainText = "abcdefgh";
    StringBuffer encrypted = new StringBuffer();

    for (char ch : plainText.toCharArray()) {
        /* Form the encrypted string */
        encrypted.append(keyMap.get(ch));

    }

    System.out.println("Encrypted: " + encrypted.toString());

}