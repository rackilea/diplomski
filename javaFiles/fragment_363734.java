Map<String,Map<String,String>> hourlyMap = new HashMap<String,Map<String,String>>();
    for(Map<String,String> i:hourlyMap.values()){
        // now i is a Map<String,String>
        for(String str:i.values()){
            // now str is a value of map i
            System.out.println(str);
        }
    }