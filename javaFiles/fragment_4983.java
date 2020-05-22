File[] files = dir.listFiles();
for (File file : files) {
    String t_text = new String(Files.readAllBytes(file.toPath()), StandardCharsets.UTF_8);
    if (t_text.contains(search_string)) {
        // do whatever you want
    }
}