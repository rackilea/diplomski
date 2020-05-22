public class MatchPairs {
    private static final String[] strs = {"GU", "UG", "IG", "GI"};
    public static int matches( String str ){
        String strToSearch = String.join( "|", strs );
        Pattern strPattern = Pattern.compile(strToSearch);
        Matcher matcher = strPattern.matcher(str);
        int counter = 0;
        while(matcher.find()) {
             ++counter;
        }
        return counter;
    }
}