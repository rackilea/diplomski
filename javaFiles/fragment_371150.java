Map<String, Object> lhm = new HashMap<>();
Map<String, Object> subMap = new HashMap<>();
subMap.put("SchemaVersion", "1.0");  // storing String value
lhm.put("my-map", subMap);  // storing Map value

// retrieval: need to query actual type of value
Object value = lhm.get("my-map");
if (value instanceOf String) {
   String strValue = (String)value;
   // process String value
} else {
   Map mapValue = (Map)value;
   // process Map value
}