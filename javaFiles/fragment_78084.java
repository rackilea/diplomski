@Test
public void testNoTx() {
    // start with a non existing database
    final OrientGraphFactory factory = new OrientGraphFactory(
        "plocal:" + DB_DIR, "admin", "admin");
    assertFalse(factory.exists());        
    try {
        OrientGraphNoTx g = factory.getNoTx();
        // database is auto created
        assertFalse(g.isClosed());
        assertFalse(g.isRequireTransaction());
    } finally {
        // this also closes the OrientGraph instances created by the factory
        // Note that OrientGraphFactory does not implement Closeable
        factory.close();
    }
}