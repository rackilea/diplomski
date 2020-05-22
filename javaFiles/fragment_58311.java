double wordCount2(String filepath) {
    try {
        return Files.lines(Paths.get(filepath))
                .map(s -> s.split(" "))
                .map(arr -> arr.length)
                .collect(Collectors.averagingDouble(Double::new));
    } catch (IOException e) {
        e.printStackTrace();
    }
    return -1.0;
}