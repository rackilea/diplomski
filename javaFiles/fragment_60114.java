//...
List<Record> records = new ArrayList<Record>()

for (File file:getAllFiles()) {
  List<String> keys = getColumnsHeaders(file);
  KeyStore.addAll(keys);  // the store is a Set
  for (String line:file.getLines()) {
    String[] values = line.split(DELIMITER);
    Record record = new Record(file.getName()+i);  // as an example for id
    for (int i = 0; i < values.length; i++) {
      record.put(keys.get(i), values[i]);
    }
    records.add(record);
  }
}
// ...