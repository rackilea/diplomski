Pattern regex = Pattern.compile("</?[a-z0-9]+(?:>|[\\s/][^>]*>)");
    Matcher regexMatcher = regex.matcher(
                   "<re STuff=caSeS></re ><NO><nO><N0T/>");

    while (regexMatcher.find()) {
        for (int i = 1; i <= regexMatcher.groupCount(); i++) {
            // matched text: regexMatcher.group(i)
            // match start: regexMatcher.start(i)
            // match end: regexMatcher.end(i)
        }
    }