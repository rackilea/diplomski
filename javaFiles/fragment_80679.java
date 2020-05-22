String input = "&l&aCheckpoint&m&6doreime";
    Pattern pattern = Pattern.compile("(((?:&|§)[0-9A-FK-ORa-fk-or])+)([^&]*)");
    Matcher patternMatcher = pattern.matcher(input);
    while(patternMatcher.find()){
        String[] codes = patternMatcher.group(1).split("(?=&)"); 
        String rest = patternMatcher.group(3); 
    }