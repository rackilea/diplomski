String id = ..
long timestamp = ...
Document doc = new Document();
// The sorted version of my EntityId
doc.add(new SortedDocValuesField("EntityId", new BytesRef(id)));
// The stored version of my EntityId to be able to get its value later if needed
doc.add(new StringField("Id", id, Field.Store.YES));
// The sorted version of my timestamp
doc.add(new NumericDocValuesField("Timestamp", timestamp));
// The stored version of my timestamp to be able to get its value later if needed
doc.add(new StringField("Tsp", Long.toString(timestamp), Field.Store.YES));