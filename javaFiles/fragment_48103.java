public static List<String> getPropertyList(List<Map<String,String>> users, String key)
{
    return users.stream()
                .map(m -> m.get(key))
                .collect(Collectors.toList());
}