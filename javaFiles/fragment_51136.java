import static java.util.Comparator.*;
//...

String[] s = {"1", "2", "3", "25"};
Optional<String> max = Stream.of(s).max(comparingInt(String::length).thenComparing(naturalOrder()));
int maxInt = Integer.parseInt(max.get());