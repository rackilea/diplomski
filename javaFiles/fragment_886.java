private static final String DOC = "The root cause of the problem is the temperature, it is currently 40 degrees which is 30 percent likely to turn into an infection doctor has prescribed 1-19666 tablet which contains 1.67 gpm and has advised to consume them every 3 hrs";

   // ...

    Pattern pattern = Pattern.compile("(\\b\\S*\\d\\S*\\b\\s+)?\\b\\S+\\b");
    Matcher matcher = pattern.matcher(DOC);
    List<String> words = new ArrayList<>();
    while (matcher.find()) {
        words.add(matcher.group());
    }
    for (String word : words) {
        System.out.println(word);
    }