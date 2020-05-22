public Boolean hasNames(String s1, String s2){
    List<String> s1List = Arrays.asList(s1.split(","));
    List<String> s2List = Arrays.asList(s2.split(","));

    for(String s : s1List)
        if(s2List.indexOf(s)>=0)
            return true;
    for(String s : s2List)
        if(s1List.indexOf(s)>=0)
            return true;
    return false;
}