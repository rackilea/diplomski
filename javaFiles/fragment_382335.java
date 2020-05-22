Pattern pattern = Pattern.compile("<([^>]+)>([^<]*)</[^>]+>");
try (Stream<String> stream = Files.lines(Paths.get(filePath))) {
    stream.forEach(
        line -> {
            System.out.println(line);
            Matcher matcher = pattern.matcher(line);
            while (matcher.find()) {
                System.out.printf("%s: %s ", matcher.group(2).trim(), matcher.group(1));
            }
            System.out.println();
        }
    );
}