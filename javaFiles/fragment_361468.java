import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import static java.util.Arrays.stream;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

import java.util.List;
import java.util.stream.Stream;

public class Anagram {
  static List<List<String>> findAnagrams(List<String> dict) {
    return dict.stream()
        .collect(groupingBy(w -> stream(w.toLowerCase().split("")).sorted().collect(joining())))
        .values().stream().filter(words -> words.size() > 1).collect(toList());
  }

  static List<String> getWords(String fileName) throws IOException {
    try (Stream<String> lines = Files.lines(Paths.get(fileName))) {
      return lines.collect(toList());
    }
  }

  public static void main(String[] args) throws IOException {
     findAnagrams(getWords("words.txt")).stream().forEach(System.out::println);
  }
}