double wordCount(String filepath) {
    try {
        return Files.lines(Paths.get(filepath))
                .map(s -> s.split(" "))
                .mapToInt(arr -> arr.length)
                .average()
                .orElse(-1.0);
    } catch (IOException e) {
        e.printStackTrace();
    }
    return -1.0;
}