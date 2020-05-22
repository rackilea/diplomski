// This works:
MyTableRecord record =
DSL.using(configuration)
   .selectFrom(MY_TABLE)
   .where(MY_TABLE.ID.eq(1))
   .fetchOne();

// These won't work:
record.store();
record.update();
record.refresh();
record.delete();

// This will still work:
record.insert();