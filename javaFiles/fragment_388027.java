for (Iterator<String> it = charsDict.keySet().iterator(); it.hasNext();) {
    String eachChar = it.next();
    if (charsDict.get(eachChar) < 2) {
        it.remove();
    }
}