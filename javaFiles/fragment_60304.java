public class PigLatinTest {

    public static void main(String[] args) {
        testPigLatin("hello", "ellohay");
        testPigLatin("welcome", "ellcomeway");
        // Add more test cases here.
    }

    private static void testPigLatin(String english, String expectedPigLatin) {
        String actual = translateWordToPigLatin(english);
        if (!expectedPigLatin.equals(actual)) {
            throw new AssertionError("Expected \"" + expectedPigLatin + "\" for \"" + english + "\", got \"" + actual "\".");
        }
    }
}