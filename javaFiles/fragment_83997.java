Charset charset = Charset.forName("UTF-8");
List<String> lines = Files.readAllLines(file.toPath(), charset);

for (String line : lines) {
    Matcher matcher = regexpPattern.matcher(line);

    if (matcher.matches()) {
        // do something
    }
}