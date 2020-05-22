try {
   db.begiTransaction();
   ...
   // your work with file and inserting
   db.setTransactionSuccessful();
   ...
}
finally {
   if (db.inTransaction()) {
      db.endTransaction();
   }
}