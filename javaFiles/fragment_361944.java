public String getDescription() {
    StringJoiner sj = new StringJoiner(" & ");

    if (line.contains("A")) {
        sj.add("Apple");
    }
    if (line.contains("B")) {
        sj.add("Banana");
    }
    if (line.contains("C")) {
        sj.add("Carrot");
    }
    return sj.toString();
}