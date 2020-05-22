for (String rank : ranks) {
    Pattern pattern = Pattern.compile("\\b" + rank + "\\s+([a-zA-Z]*)");
    Matcher m = pattern.matcher(input);
    while (m.find()) {
        System.out.println(rank);
        System.out.println(m.group(1));
    }
}