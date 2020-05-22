public static void replaceOccurrences(String match, String replacement, Path path) throws IOException {
    Files.write(path, Files.lines(path).map(l -> {
        if(l.contains(match)) {
            return l.replace(match, replacement);
        } else {
            return l;
        }
    }).collect(Collectors.toList()));
}