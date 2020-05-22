ViewQuery query = ...

Map<String, String> map = new HashMap<String, String>();
for (ViewResult.Row row : db.queryView(query)) {
    map.put(row.getId(), row.getKey());
}

return map;