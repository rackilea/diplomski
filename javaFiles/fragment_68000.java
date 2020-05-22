public void traverse() {
    MyEntity myEntity = null;
    for (String label : myEntity.getLabels()) { // <--  Offending Line
            /* ... */
    }
}