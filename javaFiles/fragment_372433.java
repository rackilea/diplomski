Database tsdb = environment.openDatabase(null, "tsdb", dbconfig);
PassageBinding binding = new PassageBinding();
DatabaseEntry idDbEntry = new DatabaseEntry();

IntegerBinding.intToEntry(id, idDbEntry);
DatabaseEntry dbEntry = new DatabaseEntry();
pb.objectToEntry(data, dbEntry);

tsdb.put(null, idDbEntry, dbEntry); // <-- replace existing value without loading it.