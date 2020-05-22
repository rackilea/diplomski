import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StackOverflow {

    public static void main(final String[] args) {

        final List<String> words = new ArrayList<>();
        words.add("key1 key2 key3 key4 key5 key6 key7");
        words.add("key11 key12 key13 key14 key15 key16 key17");

        final List<List<String>> listOfLists = words.stream().flatMap(w -> {

            final String[] wordList = w.split(" ");

            return  IntStream.range(0, Math.min(  3, wordList.length)).mapToObj(i ->          i ).flatMap(i -> Stream.of(
                    IntStream.range(i, Math.min(i+5, wordList.length)).mapToObj(j -> wordList[j])
                    .collect(Collectors.toList())));
        })          .collect(Collectors.toList());

        listOfLists.forEach(System.out::println);
    }
}