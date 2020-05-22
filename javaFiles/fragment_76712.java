public class MatchNoOverlap {
    private static final String[] strs = {"GU", "UG", "IG", "GI"};
    public static int matches( String str ){
        String strToSearch = String.join( "|", strs );
        Pattern strPattern = Pattern.compile(strToSearch);
        Matcher matcher = strPattern.matcher(str);
        int counter = 0;
        int start = 0;
        while(matcher.find(start)) {
            ++counter;
            start = matcher.start() + 2;
        }
        return counter;
    }
    public static void main( String[] args ){
        System.out.println( matches( "GOOGGOUGGUGIGI" ) );
    }
}