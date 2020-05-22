Iterable<Map<String, Object>> it = getNodes(...);

while (it.hasNext()) {
   Map<String, Object> map = it.next();
   obj = neo4jOperations.convert(map.get("member"), Node.class);
   ...
}