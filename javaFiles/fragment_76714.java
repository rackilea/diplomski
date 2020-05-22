public static int badPairs( String str ){
    String strToSearch = "(?:(?:..)*?)((?:" + String.join( "|", valids) + ")+)";
    Pattern strPattern = Pattern.compile( strToSearch);
    Matcher matcher = strPattern.matcher(str);
    int counter = 0;
    int start = 0;
    int end = 0;
    while(matcher.find( start )){
        int s = matcher.start(1);
        end = matcher.end(1);
        counter += s - start;
        start = matcher.end();
    }
    counter += str.length() - end;
    return counter/2;
}