public Map<Integer, List<Integer>> categorise() {
    final Map<Integer, List<Integer>> categorisedMarks = new HashMap<Integer, List<Integer>>();

    categorisedMarks.put(0, getMarksInRange(0, 20) );
    categorisedMarks.put(1, getMarksInRange(21, 40) );
    categorisedMarks.put(2, getMarksInRange(41, 60) );
    categorisedMarks.put(3, getMarksInRange(61, 80) );
    categorisedMarks.put(4, getMarksInRange(81, 100) );

    return categorisedMarks;
}

private List<Integer> getMarksInRange(final int lowerBonud, final int upperBound) {
    final List<Integer> marksInRange = new ArrayList<Integer>();

    for (final Integer mark : this.marks) {
        if(mark >= lowerBonud && mark <= upperBound) {
            marksInRange.add(mark);
        }
        else if (mark > upperBound) {
            break;
        }
    }

    return marksInRange;
}