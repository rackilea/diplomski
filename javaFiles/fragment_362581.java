String pattern = "(?<=watch\\?v=|/videos/|embed\\/)[^#\\&\\?]*";

    Pattern compiledPattern = Pattern.compile(pattern);
    Matcher matcher = compiledPattern.matcher(url);

    if(matcher.find()){
        return matcher.group();
    }