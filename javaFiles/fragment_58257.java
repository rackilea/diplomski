DSLContext request = DSL.using(sqlConnection, SQLDialect.MYSQL);
InsertValuesStep2<?, Object, Object> step = request.insertInto(
    DSL.table("MyTable"), DSL.field("MyColumn1"), DSL.field("MyColumn2"));

// ... some code ...

step = step.values("hello", 98);

// ... some code ...

step = values("world", 67);

// ... some code ...

step.execute();