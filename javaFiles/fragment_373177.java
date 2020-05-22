private static final TreeMap<Integer, Double> table = new TreeMap<Integer, Double>();
static {
    table.put(0,  110.3);
    table.put(5,  110.3);
    table.put(10, 110.7);
    table.put(15, 110.7);
    table.put(20, 111.2);
    table.put(25, 112.3);
}

private static double lookup(int value) {
    Entry<Integer, Double> floorEntry = table.floorEntry(value);
    if (floorEntry == null)
        return -1; // or throw sth
    return floorEntry.getValue();
}

public static void main(String[] args) {
    System.out.println(lookup(7));
}