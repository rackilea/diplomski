public static Map<String, String> getQueryMap(String query)
    {
        String[] params = query.split("&");
        Map<String, String> map = new HashMap<String, String>();
        for (String param : params)
        {
            String name = param.split("=")[0];
            String value = param.split("=")[1];
            map.put(name, value);
        }
        return map;
    }

    String query = url.getQuery();  
    Map<String, String> map = getQueryMap(query);  
    Set<String> keys = map.keySet();  
    for (String key : keys)  
    {  
       System.out.println("Name=" + key);  
       System.out.println("Value=" + map.get(key));  
    }