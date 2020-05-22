Map<String, List<String>> map = new HashMap<>();
while(recordset.next()) {
    ArrayList<String> collection = recordset.getFieldNames();
    int size = collection.size();
    for (i = 0; i <=(size-1); i++) {
        String colname = collection.get(i);
        String colval = recordset.getField(colname);
        map.computeIfAbsent(colname, k -> new ArrayList<>()).add(colval);
    }
}