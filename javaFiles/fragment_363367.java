Hashtable<String, Integer> hashtable = new Hashtable<String, Integer>();
String[] splitInput = input.split(" ");
for(String inputToken : splitInput) {
    Integer val = hashtable.get(inputToken);
    if(val == null) {
        val = new Integer(0);
    }
    ++val;
    hashtable.put(inputToken, val);
}