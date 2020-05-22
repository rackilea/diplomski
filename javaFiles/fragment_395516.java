public Boolean hasNames(String s1, String s2){
    Set<String> s1Set = new HashSet<String>();
    List<String> s2List = Arrays.asList(s2.split(","));
    for(String s : s1.split(","))
        s1Set.add(s);
    s1Set.retainAll(s2List);
    return !s1Set.isEmpty();
}