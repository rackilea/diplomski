String title = null;
        String subjectString = "<title>TextWithinTags</title>";
        Pattern titleFinder = Pattern.compile("<title[^>]*>(.*?)</title>", Pattern.DOTALL | Pattern.CASE_INSENSITIVE);
        Matcher regexMatcher = titleFinder.matcher(subjectString);
        while (regexMatcher.find()) {
            title = regexMatcher.group(1);
        }