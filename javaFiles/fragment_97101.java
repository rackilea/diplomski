...
List<Color> colors = getjdbcTemplate().query(query, new ColorMapper());
Map<Integer, String> colorMap = new LinkedHashMap<Integer, String>();
for (Color color : colors) {
    colorMap.put(color.getId(), color.getName());
}
return colorMap;