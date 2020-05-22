public class WordStats {
    private int occurrences;
    private SortedSet<Integer> lineNumbers = new TreeSet<Integer>();

    public void addOccurrence(int lineNumber) {
        occurrences++; 
        lineNumbers.add(lineNumber);
    }

    // getters ommitted for brevity
}