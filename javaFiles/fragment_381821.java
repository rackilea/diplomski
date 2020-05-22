try (
    final BufferedWriter writer = Files.newBufferedWriter(file.toPath(),
        StandardCharsets.UTF_8, StandardOpenOption.APPEND);
) {
    for (final String line: lines) {
        writer.write(line);
        writer.write('\n');
    }
    // Not compulsory, but...
    writer.flush();
}