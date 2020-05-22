List<Integer> numbers = new ArrayList<>();
for (String line : Files.readAllLines(Paths.get("/path/to/file.txt"))) {
    for (String part : line.split("\\s+")) {
        Integer i = Integer.valueOf(part);
        numbers.add(i);
    }
}