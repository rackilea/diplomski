HashMap<String, Object> hashmap = new HashMap<String, Object>();

HashMap<String, String> obj1 = new HashMap<String, String>();

ArrayList arraylist = new ArrayList();

obj1.put("bc", "52");
obj1.put("gd", "jjksa");

arraylist.add(obj1);

hashmap.put("metrics", arraylist);

Gson json = new Gson();

System.out.print(json.toJson(hashmap));