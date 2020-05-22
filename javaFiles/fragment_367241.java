String name = "Name from movie [BDremux 1080p][AC3 5.1 Castellano-DTS 5.1 Ingles+Subs][ES-EN]";
    Pattern pattern = Pattern.compile("\\[(.*?)\\]");
    Matcher matcher = pattern.matcher(name);
    while(matcher.find()){
        System.out.println(matcher.group());
    }