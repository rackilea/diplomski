Pattern patternHref = Pattern.compile(" href=\"(.*?)\"", Pattern.CASE_INSENSITIVE);
    Pattern patternSrc = Pattern.compile("src=\"(.*?)\"", Pattern.CASE_INSENSITIVE);

    Matcher matcher = patternSrc.matcher(eachResponseString);
    if (matcher.find()) {
        URL aa = new URL(url2, (matcher.group(1)));
        eachResponseString = patternUrl.matcher(eachResponseString).replaceAll(
                "(" + aa + ")");
        writer.write(eachResponseString);

    Matcher matcher1 = patternHref.matcher(eachResponseString);
    if (matcher1.find()) {
        URL aa = new URL(url2, (matcher.group(1)));
        eachResponseString = patternUrl.matcher1(eachResponseString).replaceAll(
                "(" + aa + ")");
        writer.write(eachResponseString);