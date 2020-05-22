try {
    Path p = Paths.get(path);
    Files.lines(p)
        .map(line ->line.split(",\\s*"))
        .filter(array -> array.length >= 2)
        .forEach(array -> list.put(array[0], array[1]));
} catch (IOException e) {
    e.printStackTrace();
}