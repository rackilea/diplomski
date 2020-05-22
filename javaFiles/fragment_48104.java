public static List<String> getPropertyList(List<Map<String,String>> users, String key)
{
    List<String> result = new ArrayList<String>();
    for (Map<String,String> map : users) {
        result.add(map.get(key));
    }
    return result;
}