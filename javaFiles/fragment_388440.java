public static String toString(List<List<Word>> lines) {
    return lines.stream()
        .map(l -> l.stream()
                   .map(w -> w.value)
                   .collect(() -> new StringJoiner(" "),
                            StringJoiner::add,
                            StringJoiner::merge))
        .collect(() -> new StringJoiner("\n"),
                       StringJoiner::merge,
                       StringJoiner::merge).toString();
}