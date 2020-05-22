String s = ";ytplayer.config = {foo bar};";
Pattern regex = Pattern.compile(";ytplayer\\.config\\s*=\\s*(\\{.*?});");
 Matcher matcher = regex.matcher(s);
 while(matcher.find()){
        System.out.println(matcher.group(1));
}