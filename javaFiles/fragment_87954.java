BigInteger expected = BigInteger.valueOf(1234567);
DSLContext ctx = DSL.using(new MockConnection(c -> {
    Field<BigInteger> id = DSL.field("last_insert_id()", BigInteger.class);
    Record record = DSL.using(MYSQL).newRecord(id);
    record.setValue(id, expected);
    return new MockResult[] { new MockResult(record) };
}), SQLDialect.MYSQL);

assertEquals(expected, ctx.lastID());