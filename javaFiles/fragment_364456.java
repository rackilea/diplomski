JSONObject obj = new JSONObject();
obj.put("jsonStringValue","{\"hello\":\"world\"}");
obj.put("naturalStringValue", "\"hello world\"");
System.out.println(obj.toString());
System.out.println(obj.getString("jsonStringValue"));
System.out.println(obj.getString("naturalStringValue"));