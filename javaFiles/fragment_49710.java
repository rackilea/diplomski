public void printEntry(Map.Entry<String, WordStats> entry) {
    String word = entry.getKey();
    WordStats stats = entry.getValue();
    System.out.println("The word " + word + " has been met " 
                       + stats.getOccurrences() + " time(s), on the following line(s):");
    for (Integer lineNumber : stats.getLines()) {
        System.out.println(lineNumber);
    }
}