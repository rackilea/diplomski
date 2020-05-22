/* this pattern will look for the XML tag.
    ** then, it will match [^>]+
    ** [...] will match a single character that matches SOMETHING inside the "character class."
    ** [^...] will match a single character that is NOT something inside the character class.
    ** [^>]+ will match as many characters as it can that do not match '>'
    ** putting this expression inside brackets tells the engine we want to capture it to be referenced later.
    ** '<' at the end just ensures we capture up until that point.
    */
    // create the pattern
    Pattern pattern = Pattern.compile("<F_TEXT Encoding=\"unicode\">([^>]+)<");
    // get a matcher for it
    Matcher matcher = pattern.matcher(textToExtract);
    // if we find a match
    if (matcher.find()) {
        // we can use group(1) to refer to our first capture group
        // group(0) will always return the full string matched, but we don't want the tags.
        String data= matcher.group(1);

    }