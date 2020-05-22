AttributeValue av1 = new AttributeValue("abc123");
AttributeValue av2 = new AttributeValue("whatever");
AttributeValue avM = new AttributeValue();
Map<String, AttributeValue> m = new HashMap<String, AttributeValue>();
m.put("id", av1);
m.put("name", av2);
avM.setM(m);
System.out.println(new Gson().toJson(avM));
// {"m":{"name":{"s":"whatever"},"id":{"s":"abc123"}}}

Map<String, Object> simpleMap = new HashMap<String, Object>();
simpleMap.put("id", "abc123");
simpleMap.put("name", "whatever");
AttributeValue avM2 = new AttributeValue().withM(InternalUtils.fromSimpleMap(simpleMap));
System.out.println(new Gson().toJson(avM2));
// {"m":{"name":{"s":"whatever"},"id":{"s":"abc123"}}}

String jsonStr = new Gson().toJson(avM2);
AttributeValue avM3 = new Gson().fromJson(jsonStr, AttributeValue.class);
System.out.println(avM3.getM().get("id").getS());
// abc123
System.out.println(avM3.getM().get("name").getS());
// whatever