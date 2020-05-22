public List<String> splitEvery(String source, char delimiter, int num) {
    List<String> list = new ArrayList<>();
    StringBuilder item = new StringBuilder();
    int delimCount = 0;
    for(int i=0; i<source.length(); i++) {
        char c = source.charAt(i);
        if(c == delimiter) {
            delimCount++;
        }
        if(delimCount == num) {
            delimCount = 0;
            list.add(item.toString());
            item = new StringBuilder();
        } else {
            item.append(c);
        }
    }
    list.add(item.toString());
    return list;
}