Pattern p = Pattern.compile("(\\S+)\\s+(\\S+)\\s+(\\S+)\\s+(\\S+)\\s+(\\S+)");
try (BufferedReader reader = new BufferedReader(new FileReader("test.txt"))) {
    for (String line; (line = reader.readLine()) != null; ) {
        Matcher m = p.matcher(line);
        if (! m.matches())
            throw new IllegalArgumentException("Bad data: " + line);
        String token1 = m.group(1);
        String token2 = m.group(2);
        String token3 = m.group(3);
        String token4 = m.group(4);
        String token5 = m.group(5);
        // use tokens here
    }
}