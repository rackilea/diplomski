private static final AtomicReference<Map<String, Map<Integer, String>>> hostToNodesTable 
       = new AtomicReference<>();

static Map<String, Map<Integer, String>> getTable() {
     return hostToNodesTable.get();
}


static void setTable(Map<String, Map<Integer, String>> map) {
     hostToNodesTable.set(map);
}