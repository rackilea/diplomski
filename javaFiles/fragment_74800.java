Map<Integer, Integer> frequencies = new HashMap<Integer, Integer>();

for(int i=0; i<list.size(); i++) {
    String thisWord = list.get(i);
    if(frequencies.containsKey(thisWord.length()) {
        frequencies.put(thisWord.length(), frequencies.get(thisWord.length())+1);
    }
    else {
        frequencies.put(thisWord.length(), 1);
    }
}