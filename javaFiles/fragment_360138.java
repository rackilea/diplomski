String a="[loc.x.1234] has logged in. Connects to [loc.x.983]" +
            "[loc.x.3427] has left the room.";
    String regExp="(?<=\\[).*?(?=\\])";
    Pattern p = Pattern.compile(regExp);
    Matcher m = p.matcher(a);
    while(m.find()){
        System.out.println(m.group());
    }