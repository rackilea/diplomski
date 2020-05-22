// input: {"altruism":1,"amazon":6}
String jsonInput = "{\"altruism\":1,\"amazon\":6}";

Map<String, Integer> map = new Gson().fromJson(jsonInput, new TypeToken<HashMap<String, Integer>>() {}.getType());
System.out.println(map); // {altruism=1, amazon=6}
System.out.println(map.getClass()); // class java.util.HashMap
System.out.println(map.keySet().iterator().next().getClass()); // class java.lang.String
System.out.println(map.get("altruism").getClass()); // class java.lang.Integer