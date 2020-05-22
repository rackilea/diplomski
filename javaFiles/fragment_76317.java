HashMap<String , String > map = new HashMap<>();
map.put("key0", "value0");
map.put("key1", "value1");
Set<String> keys = map.keySet();
List<String[]> valuesMap = new ArrayList<>();
for(String key:keys){
    String[] entry = {key,map.get(key)};
    valuesMap.add(entry);
}
String sql = "select * from mytable where (key, value) in (values :valuesMap)";
SqlParameterSource params = new MapSqlParameterSource("valuesMap", valuesMap);
jdbcTemplate.query(sql, params, rowMapper);