public void addDictionary(HashMap<String, Integer> incomingDictionary) {
    if (incomingDictionary == null) {
        return; // or throw runtime exception
    }
    if (totalDictionary == null) {
        return;// or throw runtime exception
    }
    if (totalDictionary.isEmpty()) {
        totalDictionary.putAll(incomingDictionary);
    } else {
        for (Entry<String, Integer> incomingIter : incomingDictionary.entrySet()) {
            String incomingKey = incomingIter.getKey();
            Integer incomingValue = incomingIter.getValue();
            Integer totalValue = totalDictionary.get(incomingKey);
            // If total dictionary contains null for the incoming key it is
            // as good as replacing it with incoming value.
            Integer sum = (totalValue == null ? 
                                            incomingValue : incomingValue == null ? 
                                                    totalValue : totalValue + incomingValue
                          );
            totalDictionary.put(incomingKey, sum);
        }
    }
}