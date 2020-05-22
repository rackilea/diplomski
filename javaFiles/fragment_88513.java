Collection<Row2<String, Integer>> field1Field2Collection = new LinkedList<>();
field1Field2Collection.add(row("1", 1));
field1Field2Collection.add(row("2", 2));
field1Field2Collection.add(row("3", 3));

Result<Record2<String, Integer>> field1Field2Results = dsl
        .select(Tables.TABLE1.FIELD1, Tables.TABLE2.FIELD2)
        .from(Tables.TABLE1)
        .join(Tables.TABLE2).on(Tables.TABLE2.PK1.eq(Tables.TABLE1.PK1))
        .where(row(Tables.TABLE1.FIELD1, Tables.TABLE2.FIELD2).in(field1Field2Collection))
        .fetch();