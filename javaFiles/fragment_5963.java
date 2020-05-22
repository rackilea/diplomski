String rx = "(?sm)^sufixpart$(.*?)^end$";
String s = "invalidsufix\nsubadatax\nsufixpart\nsubdata1\nsomerandomn\nsubdata2\nsubdatan\nend\ninvalidsufix\nsubadatax\nsufixpart\nsubdata001\nsomerandomn\nsubdata002\nsubdata00n\nend";
Pattern pattern_outer = Pattern.compile(rx);
Pattern pattern_token = Pattern.compile("(?m)^subdata\\S*$");
Matcher matcher = pattern_outer.matcher(s);
List<List<String>> res = new ArrayList<>();
while (matcher.find()){
    List<String> lst = new ArrayList<>();
    if (!matcher.group(1).isEmpty()) {                       // If Group 1 is not empty
        Matcher m = pattern_token.matcher(matcher.group(1)); // Init the second matcher
        while (m.find()) {                       // If a token is found
            lst.add(m.group(0));                 //    add it to the list
        }
    }
    res.add(lst);                                // Add the list to the result list
} 
System.out.println(res); // => [[subdata1, subdata2, subdatan], [subdata001, subdata002, subdata00n]]