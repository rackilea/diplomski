public List<String> splitEvery(String source, char delimiter, int num) {
    List<String> list = new ArrayList<>();
    int delimCount = 0;
    int startOfCurrentItem = 0;
    for(int i=0; i<source.length(); i++) {
        char c = source.charAt(i);
        if(c == delimiter) {
            delimCount++;
        }
        if(delimCount == num) {
            delimCount = 0;
            list.add(source.substring(startOfCurrentItem, i));
            startOfCurrentItem = i+1;
        } 
    }
    list.add(source.substring(startOfCurrentItem, source.length()));
    return list;
}