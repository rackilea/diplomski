// Are the same
List<Integer> values = new ArrayList<Integer>();
List<Integer> values = new ArrayList<>();

// Raw types, don't use if > Java 5
List values = new ArrayList();
// Assigning a raw-type to a generic variable, mixing both, don't use
List<Integer> values = new ArrayList();