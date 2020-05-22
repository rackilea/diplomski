MapWrapper wrapper = new MapWrapper();
wrapper.wrapped.put("key1", 1);
wrapper.wrapped.put("key2", 2);

String json = gson.toJson(wrapper, MapWrapper.class);
System.out.println(json);

MapWrapper newWrapper = gson.fromJson(json, MapWrapper.class);
for(Entry<String, Integer> e : newWrapper.wrapped.entrySet()) {
    System.out.println(e.getKey() + ", " + e.getValue());
}