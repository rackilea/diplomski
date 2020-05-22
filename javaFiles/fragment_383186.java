public void addObject(String key, Object object) {
       List<Object> objects = map.get(key);
       if (objects == null) {
           objects = new ArrayList<Object>();
           map.put(key, objects);
       }
       objects.add(object);
   }