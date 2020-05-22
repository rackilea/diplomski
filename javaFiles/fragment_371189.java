public static HashSet<String> put_to_hash(String key, String value) 
{
    if (!q_valMap.containsKey(key)) {
        q_valMap.put(key, new HashSet<String>());
    } 
    HashSet<String> valSet = q_valMap.get(key);
    valSet.add(value);
    return valSet;
}