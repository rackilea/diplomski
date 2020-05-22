LinkedHashMap<String, Object> holder = new LinkedHashMap<String, Object>();
final HashMap<String, LinkedHashMap<String, Object>> mainHolder = new LinkedHashMap<String, LinkedHashMap<String, Object>>();

holder.put("firstName", "Alex");
holder.put("lastName", "Cruz");
mainHolder.put("apple", holder);

holder = new LinkedHashMap<>();

LinkedHashMap<String, Object> temp = mainHolder.get("apple");
temp.put("quantity",13);
mainHolder.put("apple",temp);

System.out.println(mainHolder);