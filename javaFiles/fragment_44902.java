// Create an AccountRecord that contains your POJO data
Record rec = db.newRecord(ACCOUNT);
rec.from(account);

// Don't pass the columns to the insert statement explicitly
db.insertInto(ACCOUNT)

// But pass the record to the set method. It will use all the changed values
  .set(rec)

// Use the MySQL syntax, which can be emulated on PostgreSQL using ON CONFLICT
  .onDuplicateKeyUpdate()

// But pass the record to the set method again
  .set(rec)

// Don't specify any columns to the returning clause. It will take all the ACCOUNT columns
  .returning()
  .fetchOne();