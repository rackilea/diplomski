import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class CrackViginere {

    private static final int ALPHABET_SIZE = 26;
    private static final char FIRST_CHAR_IN_ALPHABET = 'A';

    public static void main(final String[] args) {
        String encrypted =
                "BYOIZRLAUMYXXPFLPWBZLMLQPBJMSCQOWVOIJPYPALXCWZLKXYVMKXEHLIILLYJMUGBVXBOIRUAVAEZAKBHXBDZQJLELZIKMKOWZPXBKOQALQOWKYIBKGNTCPAAKPWJHKIAPBHKBVTBULWJSOYWKAMLUOPLRQOWZLWRSLEHWABWBVXOLSKOIOFSZLQLYKMZXOBUSPRQVZQTXELOWYHPVXQGDEBWBARBCWZXYFAWAAMISWLPREPKULQLYQKHQBISKRXLOAUOIEHVIZOBKAHGMCZZMSSSLVPPQXUVAOIEHVZLTIPWLPRQOWIMJFYEIAMSLVQKWELDWCIEPEUVVBAZIUXBZKLPHKVKPLLXKJMWPFLVBLWPDGCSHIHQLVAKOWZSMCLXWYLFTSVKWELZMYWBSXKVYIKVWUSJVJMOIQOGCNLQVXBLWPHKAOIEHVIWTBHJMKSKAZMKEVVXBOITLVLPRDOGEOIOLQMZLXKDQUKBYWLBTLUZQTLLDKPLLXKZCUKRWGVOMPDGZKWXZANALBFOMYIXNGLZEKKVCYMKNLPLXBYJQIPBLNMUMKNGDLVQOWPLEOAZEOIKOWZZMJWDMZSRSMVJSSLJMKMQZWTMXLOAAOSTWABPJRSZMYJXJWPHHIVGSLHYFLPLVXFKWMXELXQYIFUZMYMKHTQSMQFLWYIXSAHLXEHLPPWIVNMHRAWJWAIZAAWUGLBDLWSPZAJSCYLOQALAYSEUXEBKNYSJIWQUKELJKYMQPUPLKOLOBVFBOWZHHSVUIAIZFFQJEIAZQUKPOWPHHRALMYIAAGPPQPLDNHFLBLPLVYBLVVQXUUIUFBHDEHCPHUGUM";
        int keyLength = 6;

        char mostCommonCharOverall = 'E';

        // Blocks
        List<String> blocks = new ArrayList<>();
        for (int startIndex = 0; startIndex < encrypted.length(); startIndex += keyLength) {
            int endIndex = Math.min(startIndex + keyLength, encrypted.length());
            String block = encrypted.substring(startIndex, endIndex);
            blocks.add(block);
        }

        System.out.println("Individual blocks are:");
        blocks.forEach(System.out::println);

        // Frequency
        List<Map<Character, Integer>> digitToCounts = Stream.generate(HashMap<Character, Integer>::new)
                .limit(keyLength)
                .collect(Collectors.toList());

        for (String block : blocks) {
            for (int i = 0; i < block.length(); i++) {
                char c = block.charAt(i);
                Map<Character, Integer> counts = digitToCounts.get(i);
                counts.compute(c, (character, count) -> count == null ? 1 : count + 1);
            }
        }

        List<List<CharacterFrequency>> digitToFrequencies = new ArrayList<>();
        for (Map<Character, Integer> counts : digitToCounts) {
            int totalCharacterCount = counts.values()
                    .stream()
                    .mapToInt(Integer::intValue)
                    .sum();
            List<CharacterFrequency> frequencies = new ArrayList<>();
            for (Map.Entry<Character, Integer> entry : counts.entrySet()) {
                double frequency = entry.getValue() / (double) totalCharacterCount;
                frequencies.add(new CharacterFrequency(entry.getKey(), frequency));
            }
            Collections.sort(frequencies);
            digitToFrequencies.add(frequencies);
        }

        System.out.println("Frequency distribution for each digit is:");
        digitToFrequencies.forEach(System.out::println);

        // Guessing
        StringBuilder keyBuilder = new StringBuilder();
        for (List<CharacterFrequency> frequencies : digitToFrequencies) {
            char mostFrequentChar = frequencies.get(0)
                    .getCharacter();
            int keyInt = mostFrequentChar - mostCommonCharOverall;
            keyInt = keyInt >= 0 ? keyInt : keyInt + ALPHABET_SIZE;
            char key = (char) (FIRST_CHAR_IN_ALPHABET + keyInt);
            keyBuilder.append(key);
        }

        String key = keyBuilder.toString();
        System.out.println("The guessed key is: " + key);

        System.out.println("Decrypted message:");
        System.out.println(decrypt(encrypted, key));
    }

    private static String decrypt(String encryptedMessage, String key) {
        StringBuilder decryptBuilder = new StringBuilder(encryptedMessage.length());
        int digit = 0;
        for (char encryptedChar : encryptedMessage.toCharArray())
        {
            char keyForDigit = key.charAt(digit);

            int decryptedCharInt = encryptedChar - keyForDigit;
            decryptedCharInt = decryptedCharInt >= 0 ? decryptedCharInt : decryptedCharInt + ALPHABET_SIZE;
            char decryptedChar = (char) (decryptedCharInt + FIRST_CHAR_IN_ALPHABET);
            decryptBuilder.append(decryptedChar);

            digit = (digit + 1) % key.length();
        }
        return decryptBuilder.toString();
    }

    private static class CharacterFrequency implements Comparable<CharacterFrequency> {
        private final char character;
        private final double frequency;

        private CharacterFrequency(final char character, final double frequency) {
            this.character = character;
            this.frequency = frequency;
        }

        @Override
        public int compareTo(final CharacterFrequency o) {
            return -1 * Double.compare(frequency, o.frequency);
        }

        private char getCharacter() {
            return character;
        }

        private double getFrequency() {
            return frequency;
        }

        @Override
        public String toString() {
            return character + "=" + String.format("%.3f", frequency);
        }
    }
}