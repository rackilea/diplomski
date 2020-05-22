public void testRowsToBeRead(){
    HashSet<SomeObject> expectedRows = new HasSet<SomeObject();
    expectedRows.add(new SomeObject("a", "a1"));
    expectedRows.add(new SomeObject("b", "b1"));

    HashSet<SomeObject> rows = new SomeObject().read();

    for(SomeObject r : rows) {
        SomeObject expected = expectedRows.get(r); // equals and hashCode must still match

        if (expected == null) {
            // failed
        }

        if (!expected.getField1().equals(r.getField1()) && !expected.getField2().equals(r.getField2())) {
            // failed
        }
    }
}