queryResult = namedParameterJdbcTemplateHive.queryForList(query, paramSource);

Map<String, Object> newMap = new HashMap<>();
for (Map.Entry<String, Object> entry : map.entrySet()) {
   String[] keyData = entry.getKey().split("\\.");
   if (keyData.length > 1) {
       newMap.put(keyData[1], entry.getValue());
   } else {
       newMap.put(entry.getKey(), entry.getValue());
   }
}