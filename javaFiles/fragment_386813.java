public static void main( String[] args ) {
    String input = "New England 12 Philidelphia 24 (Final)";
    String regex = "([a-zA-Z ]+)\\s+(\\d+)\\s+([a-zA-Z ]+)\\s+(\\d+)\\s+\\((\\w+)\\)";
    Matcher matcher = Pattern.compile( regex ).matcher( input);
    while (matcher.find( )) {
        String team1 = matcher.group(1);
        String score1 = matcher.group(2);
        String team2 = matcher.group(3);
        String score2 = matcher.group(4);
        String result = matcher.group(5);
        System.out.println( team1 + " scored " + score1 + ", " + team2 + " scored " + score2 + ", which was " + result);
    }
}