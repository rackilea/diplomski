StringBuilder sb = new StringBuilder();
try {
    Files.lines(Path.of("test.txt")).forEach(x -> {
        String[] split = x.split(",");
        split = stream(split).map(y -> {
            String cleaned = y.strip().replaceAll(">$|^<", "").strip();
            return cleaned;
        }).toArray(String[]::new);
        String email = split[2];
        // TODO: other data
        if (email.isBlank()) {
            System.err.println("No email address");
        }
        // TODO: other checks
        sb.append(String.join(", ", split));
        sb.append(System.lineSeparator());
    });
} catch (IOException e) {
    e.printStackTrace();
}

String result = sb.toString();