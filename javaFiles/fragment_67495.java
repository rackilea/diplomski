Map<String,Object> a = new HashMap<String,Object>();
a.put("Count", 5);
a.put("Message", "A string.");

int count = (Integer)a.get("Count"); //better use Integer instead of int to avoid NPE
String message = (String)a.get("Message");