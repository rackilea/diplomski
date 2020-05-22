public void testRowsToBeRead(){
    HashSet<SomeObject> expectedRows = new HasSet<SomeObject();
    expectedRows.add(new SomeObject("abc"));
    expectedRows.add(new SomeObject("def"));

    HashSet<SomeObject> rows = new SomeObject().read();

    // alternative 1
    assertEquals(19, rows.size());

    for(SomeObject r:rows){
        if (!expectedRows.contains(r)) {
            // test failed
        }
    }

    // alternative 2
    assertTrue(expectedRows.equals(rows));
}