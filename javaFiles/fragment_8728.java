Pattern pattern = Pattern.compile("#([^#]+)#");
    Matcher matcher = pattern.matcher("I #have# #a# #string#");
    while(matcher.find()){
        String y = matcher.group(1);
        // do something with y
    }