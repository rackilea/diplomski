public class CharacterToZeroBasedIntegerRange {

    public static int characterToIntegerRange(char c) {
        if (c < 'a' || c > 'z') {
            throw new IllegalArgumentException(String.format("Character with value %04X is not a letter", (int) c));
        }

        return c - 'a';
    }

    public static void main(String[] args) {
        String test = "Hello world!".toLowerCase().replaceAll("[^a-z]", "");
        System.out.println(test);
        for (int i = 0; i < test.length(); i++) {
            char c = test.charAt(i);
            System.out.println(characterToIntegerRange(c));
        }
    }
}