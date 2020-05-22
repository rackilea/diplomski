Map<Integer, Integer> frequencies = new HashMap<Integer, Integer>();

for(int i=0; i<list.size(); i++) {
    String thisWord = list.get(i);
    Integer theLength = (Integer)(thisWord.length());
    if(frequencies.containsKey(theLength) {
        frequencies.put(theLength, new Integer(frequencies.get(theLength).intValue()+1));
    }
    else {
        frequencies.put(theLength, new Integer(1));
    }
}