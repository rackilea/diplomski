static class Str {

    final String origin;
    final int uppers;

    Str(String origin) {
        this.origin = origin;
        this.uppers = (int)origin.chars()
            .filter(Character::isUpperCase)
            .count();
    }
}

public static List<String> uniq(String file) throws IOException {
    Path path = Paths.get(file);
    List<String> lines = Files.readAllLines(path);
    Map<String, Str> map = new LinkedHashMap<>();
    for (String e : lines) {
        Str n = new Str(e);
        map.compute(e.toLowerCase(),
            (k, v) -> v == null || n.uppers > v.uppers ? n : v);
    }
    return map.values().stream()
        .map(s -> s.origin)
        .collect(Collectors.toList());
}