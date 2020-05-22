Pattern regex = Pattern.compile("\\b[abc]+\\b");
    Matcher regexMatcher = regex.matcher(subjectString);
    while (regexMatcher.find()) {
        // matched text: regexMatcher.group()
        // match start: regexMatcher.start()
        // match end: regexMatcher.end()
    }