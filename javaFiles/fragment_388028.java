for (Iterator<Map.Entry<String, Integer>> it = charsDict.entrySet().iterator(); it.hasNext();) {
    Map.Entry<String, Integer> e = it.next();
    String eachChar = e.getKey();
    int value = e.getValue();
    if (value < 2) {
        it.remove();
    }
}