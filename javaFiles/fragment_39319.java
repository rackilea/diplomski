Map<String,String> map = new HashMap();
    String str = "fail:2,success:1,fetch:1";
    String[] keyValueParts = str.split(",");
    for(String s  : keyValueParts){
        String parts[] = s.split(":");
        map.put(parts[0],parts[1]);
    }

    System.out.println(map);