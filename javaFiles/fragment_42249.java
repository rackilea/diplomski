Gson gson = new Gson();
Type type = new TypeToken<Map<String, List<long[]>>>(){}.getType();
Map<String, List<long[]>> trafficInput = new HashMap<>();
trafficInput = gson.fromJson("{\"paris\":[[1485907200000,182184411,41274],[1485993600000,151646118,36697]],\"london\":[[1485907200000,30200160,155827]]}", type);
System.out.println(trafficInput);
System.out.println(gson.toJson(trafficInput));