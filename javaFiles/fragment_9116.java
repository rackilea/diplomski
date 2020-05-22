public static User parse(String text) {
    List<String> matchList = new ArrayList<String>();
    Pattern regex = Pattern.compile("[^\\s\"']+|\"([^\"]*)\"|'([^']*)'");
    Matcher regexMatcher = regex.matcher(text);
    while (regexMatcher.find()) {
        if (regexMatcher.group(1) != null) {
            matchList.add(regexMatcher.group(1));
        } else if (regexMatcher.group(2) != null) {
            matchList.add(regexMatcher.group(2));
        } else {
            matchList.add(regexMatcher.group());
        }
    }
    System.out.println(matchList);
    String[] name = matchList.get(0).split(" ");
    String[] address = matchList.get(1).split("/");
    return new User(name[0], name[1], address[0], address[1], address[2], Double.parseDouble(matchList.get(2)));
}