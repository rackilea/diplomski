Map<String, String> queriesByKeys = new HashMap<>();
for (String key : props.keySet())
{
    if (!key.startsWith("view"))
        continue;

    String queryKey = key.replace("view", "query");
    String queryValue = props.getPropertyValue(queryKey);

    String ids = props.getPropertyValue(key);
    for (String id : ids.split(","))
        queriesByKeys.put(id, queryValue);
}