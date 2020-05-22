List<List<String>> itrr = new ArrayList<>();
    for (int i = startLoop; i <= endLoop; i++) {
        List<String> listOfString = new ArrayList<>();
        for (int j = startInnerLoop; j <= endInnerLoop; j++) {
            ...
            listOfString.add(...);
        }
        itrr.add(listOfString);
}
Iterator<List<String>> iter = ittr.iterator();