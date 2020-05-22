String procedureName = "stored_proc";

Map<String, Object> inMap = new LinkedHashMap<String, Object>();
inMap.put("parameter1", "10");
inMap.put("parameter2", "|Lib");
inMap.put("parameter3", "P");   

Map<String, Object> outMap = new LinkedHashMap<String, Object>();
outMap.put("output", 0);
outMap.put("output1", "");

Map resultMap = genericDatabaseCaller.executeSimpleProcedure(procedureName, inMap, outMap);