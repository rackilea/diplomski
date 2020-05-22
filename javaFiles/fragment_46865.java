List<List<String>> dict = new ArrayList<>();
for(string s: stringsList) {
    int len = s.length();
    // add new array lists as required, could be any length, assuming << 100
    while(dict.size() <= len) dict.add(new ArrayList<String>());
    // add the string to the right list.
    dict.get(len).add(s);
}