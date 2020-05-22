public class RegExPattern {

    public static void main(String[] args) {
        String test1 = "What is @TWITTERHANDLE tweeting about?";
        String test2 = ":TWalk!46774664@gateway/web/freenode/ip.11.222.33.444 PRIVMSG #irchacks :What is @TWalkBot tweeting about right now?";

        Pattern pattern = Pattern.compile(".*@(\\w+).*tweeting.*");
        Matcher matcher = pattern.matcher(test1);
        if(matcher.find()){
            System.out.println(matcher.group(1)); //Sysouts TWITTERHANDLE
        }

        matcher = pattern.matcher(test2);
        if(matcher.find()){
            System.out.println(matcher.group(1)); //Sysouts TWalkBot
        }
    }
}