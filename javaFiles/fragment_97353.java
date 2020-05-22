import static java.util.stream.Collectors.joining;

public static void main(String[] args) throws Exception {

    final List<String> strings = Arrays.asList("a", "b", "c");

    final String joined = strings.stream()
            .collect(joining(") (", "(", ")"));

    System.out.println(joined);
}