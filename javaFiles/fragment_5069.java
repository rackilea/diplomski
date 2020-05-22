List<Map<String, String>> listOfMaps = new ArrayList<>();
while(recordset.next()) {
    ArrayList<String> collection = recordset.getFieldNames();
    int size = collection.size();
    Map<String, String> values = new HashMap<>();
    for (i = 0; i <=(size-1); i++) {
        String colname = collection.get(i);
        String colval = recordset.getField(colname);
        values.put(colname, colval);
    }
    listOfMaps.add(values);
}