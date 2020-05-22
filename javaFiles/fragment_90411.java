Map<Long,Map<String,String>> mapOfMaps = new HashMap<>();
mapOfMaps.put(1L,new HashMap());
mapOfMaps.put(2L,new HashMap());
mapOfMaps.get(1L).put("key1","value1");
mapOfMaps.get(1L).put("key2","value2");
mapOfMaps.get(2L).put("key3","value3");
mapOfMaps.get(2L).put("key4","value4");