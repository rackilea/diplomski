public class DemoApplication {

    public static final String UTF8_BOM = "\uFEFF";

    private static String removeUTF8BOM(String s) {
        if (s.startsWith(UTF8_BOM)) {
            s = s.substring(1);
        }
        return s;
    }

    private static final String PATH = "words.txt";

    private static final String REGEX = " ";

    public static void main(String[] args) throws IOException {

        Map<String, Long> frequencyMap;
        try (BufferedReader reader = new BufferedReader(new FileReader(PATH))) {
            frequencyMap = reader
                    .lines()
                    .flatMap(s -> Arrays.stream(s.split(REGEX)))
                    .map(DemoApplication::removeUTF8BOM)
                    .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        }

        frequencyMap
                .entrySet()
                .stream()
                .sorted(Comparator.comparingLong(Map.Entry::getValue))
                .limit(20)
                .forEach(System.out::println);
    }
}