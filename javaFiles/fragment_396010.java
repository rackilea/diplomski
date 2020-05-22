db.beginTransaction();

try {
  // do your SQL work here
  db.setTransactionSuccesful();
}
catch (Exception e) {
  // logging, event bus message to UI, whatever
}
finally {
  db.endTransaction();
}