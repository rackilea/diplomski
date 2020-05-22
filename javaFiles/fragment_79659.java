// text from your comment
String sb = "hello my name is, etc, etc, etc, [{ md : "
        + "{o : \"set\", et : _LU.et.v.v }, d : {t : "
        + "_LU.el.searchtype, l : _LU[_LU.el.searchtype].nfts.l, "
        + "v : _LU[_LU.el.searchtype].nfts.v}}, { md : {o : "
        + "\"set\", et : _LU.et.v.v }, d : {t : _LU.el.topicgroup, "
        + "l : \"Books\", v : \"ETBO\"}}] , "
        + "some more text here, and some more";

Pattern searchPattern = Pattern.compile("\\[\\{(.+?)\\}\\]");
Matcher matcher = searchPattern.matcher(sb);

// pattern that finds words between quotes
Pattern serchWordsInQuores = Pattern.compile("\"(.+?)\"");

// here I will collect words in quotes placed in [{ and }] and separate 
// them with one space
StringBuilder words = new StringBuilder();

// buffer used while replacing [{ xxx }] part with words found in xxx
StringBuffer output = new StringBuffer();

while (matcher.find()) {// looking for [{ xxx }]
    words.delete(0, words.length());

    //now I search for words in quotes from [{ xxx }]
    Matcher m = serchWordsInQuores.matcher(matcher.group());
    while (m.find())
        words.append(m.group(1)).append(" ");

    matcher.appendReplacement(output, words.toString().trim());
    //trim was used to remove last space
}
//we also need to append last part of String that wasn't used in matcher
matcher.appendTail(output);

System.out.println(output);