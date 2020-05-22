public static Boolean isContains(char[] charOfWords, char[] charOfSrch) {
    List<Character> searchFor = new ArrayList<>();
    List<Character> searchMe=new ArrayList<>();
    for(char c:charOfWords)
        searchFor.add(c);
    for(char c:charOfSrch)
        searchMe.add(c);

    for(int x=searchFor.size()-1;x>=0;x--){
        if(searchMe.contains(searchFor.get(x)){
            searchMe.remove(searchFor.get(x));
            searchFor.remove(x);//line A
        }                
    }
    return searchFor.size()==0;
}