private static final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
public static final String KEY = "AB";

public String encode(String input) {
    StringBuilder letters = new StringBuilder();
    input = input.toUpperCase();
    for (int i = 0, j = 0; i < input.length(); i++) {
        char symbol = input.charAt(i);
        char keySymbol = KEY.charAt(j);
        int newIndex =
            (ALPHABET.indexOf(symbol) + ALPHABET.indexOf(keySymbol))
                % ALPHABET.length();
        char newSymbol = ALPHABET.charAt(newIndex);
        letters.append(newSymbol);
        j = ++j % KEY.length();
    }
    return letters.toString().toLowerCase();
}