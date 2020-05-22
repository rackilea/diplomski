public enum Row {
    NUMBER, LETTER, SYMBOL, WHATEVER1, WHATEVER2
}

public static class Col {
    Map<Row, String> col = new HashMap<>();

    public Col(Entry<Row, String>... entries) {
        for (Entry<Row, String> entry: entries) {
            col.put(entry.getKey(), entry.getValue());
        }
    }

    // to use within a LinkedHashSet
    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;
        return Objects.equals(col, ((Col) other).col);
    }

    @Override
    public int hashCode() { return Objects.hash(col); }

    @Override
    public String toString() { return col.toString(); }
}


public static void main(String[] argv) {
    // alternatively use LinkedHashSet directly
    List<Col> cols = new ArrayList<>();
    cols.add(new Col(new SimpleEntry<>(Row.NUMBER, "1"), new SimpleEntry<>(Row.LETTER, "A"), new SimpleEntry<>(Row.WHATEVER1, "X")));
    cols.add(new Col(new SimpleEntry<>(Row.NUMBER, "2"), new SimpleEntry<>(Row.LETTER, "B"), new SimpleEntry<>(Row.SYMBOL, "!")));
    cols.add(new Col(new SimpleEntry<>(Row.NUMBER, "1"), new SimpleEntry<>(Row.LETTER, "A"), new SimpleEntry<>(Row.WHATEVER1, "X")));

    // turn original structure unique keeping order of insertion
    Set<Col> unique = new LinkedHashSet<>(cols);

    System.out.println(unique);
}