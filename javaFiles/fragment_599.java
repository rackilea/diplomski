Pattern regex = Pattern.compile(
    "^               # Anchor search to start of string\n" +
    "(?=.*s1)        # Check if string contains s1\n" +
    "(?=.*s2)        # Check if string contains s2\n" +
    "(?=.*s3)        # Check if string contains s3", 
    Pattern.DOTALL | Pattern.COMMENTS);
Matcher regexMatcher = regex.matcher(subjectString);
foundMatch = regexMatcher.find();