DSLContext create = DSL.using(configuration);
// This intermediate result is only used to extract ID values later on
Result<MyTableRecord> result = create.newResult(MY_TABLE);
result.add(record1);
result.add(record2);

create.delete(MY_TABLE)
      .where(MY_TABLE.ID.in(result.getValues(MY_TABLE.ID))
      .execute();