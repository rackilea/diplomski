import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.List;
import java.util.stream.Collectors;
import java.util.function.Function;

    public static List<CharFrequency> mostCommonChars(Set<String> dictionary) {
    // Concat all strings present in dictionary into a big string
    String allchars = dictionary.stream().collect(Collectors.joining());
    // Then convert it to a List<Character> which can use Java Streams
    List<Character> charList = new ArrayList<>(allchars.length());
    for (char c : allchars.toCharArray()) {
        charList.add(c);
    }

    final List<CharFrequency> result = new ArrayList<>();
    charList.stream()
            // Group by the char itself and count occurrences
            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
            .forEach((character, count1) -> result.add(new CharFrequency(character, count1)));
    return result;
}