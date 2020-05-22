private static Date safeParse(DateFormat dateFormat, String str) {
    try {
        return dateFormat.parse(str);
    } catch (ParseException e) {
        throw new RuntimeException(e);
    }
}

public static void main(String[] args) {
    DateFormat format = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
    Comparator<String> comparator = (a, b) -> safeParse(format, a).compareTo(safeParse(format, b));

    Set<String> uniqueStrings = new TreeSet<>(comparator);

    uniqueStrings.add("03/03/2016  00:00:00");
    uniqueStrings.add("03/03/2016  00:30:00");
    uniqueStrings.add("03/03/2016  01:00:00");
    uniqueStrings.add("03/03/2016  00:30:00");
    uniqueStrings.add("03/03/2016  00:01:00");

    uniqueStrings.stream().forEach(System.out::println);
}