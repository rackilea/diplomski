public static void main(String[] args) {
    produce("element1-element2-element3-element4a|element4b"
        + "-element5-element6a|element6b");
}

private static void produce(String input) {
    String[] sequence = input.split("-");
    String[][] elements = new String[sequence.length][];
    for (int i = 0; i < sequence.length; ++i) {
        elements[i] = sequence[i].split("\\|");
    }
    List<String> results = new ArrayList<>();
    walk(results, elements, 0, new StringBuilder());
}

private static void walk(List<String> results, String[][] elements,
        int todoIndex, StringBuilder done) {
    if (todoIndex >= elements.length) {
        results.add(done.toString());
        System.out.println(done);
        return;
    }
    int doneLength = done.length();
    for (String alternative : elements[todoIndex]) {
        if (done.length() != 0) {
            done.append('-');
        }
        done.append(alternative);
        walk(results, elements, todoIndex + 1, done);
        done.setLength(doneLength); // Undo
    }
}