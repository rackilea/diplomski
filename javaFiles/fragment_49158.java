public static Set<String> getMentionedUsers(List<Tweet> tweets) {
    Set<String> mentionedUsers = new TreeSet<>();
    String regex = "(?<=^|(?<=[^a-zA-Z0-9-_\\\\.]))@([A-Za-z][A-Za-z0-9_]+)";

    Pattern p = Pattern.compile(regex);
    for(Tweet tweet : tweets){
        Matcher matcher = p.matcher(tweet.getText().toLowerCase());
        while (matcher.find()) {
            mentionedUsers.add(matcher.group(0));
        }
    }
    return mentionedUsers;
}