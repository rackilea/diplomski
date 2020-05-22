Map<String, String> songMap = new HashMap<String, String>();

    Pattern pattern = Pattern
            .compile(".*<key>(.+)</key><(.+)>(.+)</.+>.*");

    String[] lines = songString.split("\n");

    for (String line : lines) {
        Matcher matcher = pattern.matcher(line);
        if (matcher.matches()) {
            songMap.put(matcher.group(1), matcher.group(3));
        }
    }