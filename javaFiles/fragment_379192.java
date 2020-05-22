String s = "<img height=\"132\" src=\"NEW_myurl.jpg\" width=\"112\"><link src=\"/test/test.css\"/><img src=\"myurl.jpg\" width=\"12\" height=\"32\">";
Pattern pattern = Pattern.compile("(<img\\b|(?!^)\\G)[^>]*?\\b(src|width|height)=([\"']?)([^\"]*)\\3");
Matcher matcher = pattern.matcher(s);
while (matcher.find()){
    if (!matcher.group(1).isEmpty()) { // We have a new IMG tag
        System.out.println("\n--- NEW MATCH ---");  
    }
    System.out.println(matcher.group(2) + ": " + matcher.group(4));
}