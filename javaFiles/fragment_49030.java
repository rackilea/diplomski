List<String>input = new LinkedList<String>();
while(userInputString.length()>0){
    for (final Pattern p : myRegexes){
        final Matcher m = p.matcher(userInputString);
        if(m.find()) {
            input.add(m.group());
            //Remove the token we found from the user's input string so that we
            //can match the rest of the string against our regular expressions.
            userInputString=userInputString.substring(m.group().length());
            break;
        }
    }
}