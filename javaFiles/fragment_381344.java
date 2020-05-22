try (BufferedReader reader =
    Files.newBufferedReader(Paths.get(filename), Charset.defaultCharset())) {

    IntStream chars = reader.lines().flatMapToInt(String::codePoints);
    chars.forEachOrdered(c -> {
        if ((c >= 0x2639 && c <= 0x263b) ||
            (c >= 0x1f600 && c < 0x1f650) ||
            (c >= 0x1f910 && c < 0x1f930)) {

            processEmoji(c);
        }
    });
}