DSLContext request = DSL.using(sqlConnection, SQLDialect.MYSQL);
InsertQuery<?> insert = request.insertQuery(DSL.table("MyTable"));

// ... some code ...

insert.addValue(DSL.field("MyColumn1", String.class), "hello"))
insert.addValue(DSL.field("MyColumn1", Integer.class), 98))

// ... some code ...

insert.newRecord();
insert.addValue(DSL.field("MyColumn1", String.class), "world"))
insert.addValue(DSL.field("MyColumn1", Integer.class), 67))

// ... some code ...

insert.execute();