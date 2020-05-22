import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class Duplicates {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("2#3#1#0",
                                          "1#0#4#1",
                                          "9#2#5#0",
                                          "4#2#3#2",
                                          "1#1#2#1");
        System.out.println(
            list.stream()
                .flatMapToInt(s -> IntStream.of(s.charAt(0), s.charAt(4)))
                .distinct()
                .count());
    }
}