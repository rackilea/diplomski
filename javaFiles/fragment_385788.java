Map<String,String> map = new LinkedHashMap<>();
 map.put("Active","33");
 map.put("Renewals Completed","3");
 map.put("Application","15");
 Map.Entry<String,String> entry = map.entrySet().iterator().next();
 String key= entry.getKey();
 String value=entry.getValue();
 System.out.println(key);
 System.out.println(value);