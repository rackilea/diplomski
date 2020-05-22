String groups="{ group1=groupName group2=groupName minAge= maxAge= ages=[[18.0,21.0,14.7],[17.3,13.0,12.0]] }";
    String pattern = "(\\[\\[.+\\]\\])";
    Pattern r = Pattern.compile(pattern);
    Matcher m = r.matcher(groups);
    if (m.find( )) 
        System.out.println(m.group());