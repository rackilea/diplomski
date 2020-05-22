//arr is your JSONArray here
    Iterator<Object> iterator = arr.iterator();
    while (iterator.hasNext()) {
        Object obj = iterator.next();
        if(obj instanceof JSONObject) {
             System.out.println(obj.get("name"));
        }
    }