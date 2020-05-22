String link = "http://www.espncricinfo.com/netstorage/817215.json?xhr=1";
    Pattern pattern = Pattern.compile("((https?://)[^/]+/?)");
    Matcher matcher = pattern.matcher(link);

    while (matcher.find()) {
        System.out.println(matcher.group(1));
    }