private <T> void getPut(Column<T> c) throws SQLException {
    // Compiles because the type's capture, which in non-wildcard, has been bound to T
    put(c, get(c));
}

public void doExtraction() throws SQLException {
    Collection<Column<?>> cols = getColumns(); 
    for(Column<?> c : cols) {
        // Compiles because wild-card type of c is only used once
        getPut(c);  
    }
}