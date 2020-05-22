URL srcURL = new URL("http://wiki.puzzlers.org/pub/wordlists/unixdict.txt");
try(InputStream is = srcURL.openStream();
    BufferedReader reader = new BufferedReader(new InputStreamReader(is));
    Stream<String> stream = reader.lines()) {

    stream.collect(Collectors.groupingBy(s -> getAnagramKey(s)))
        .values().stream()
        .filter(l -> l.size() > 1)
        .forEach(System.out::println);
}