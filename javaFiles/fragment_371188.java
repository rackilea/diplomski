public static HashSet<String> put_to_hash(String key, String value) 
{
    if (!q_valMap.containsKey(key)) 
    {
        return q_valMap.put(key, new HashSet<String>() );
    }
    HashSet<String> list = q_valMap.get(key);
    list.add(value);
    return q_valMap.put(key, list);
}