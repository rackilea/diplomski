Map<String,Optional<Map<String,Object>>> result = 
    payments.stream ().collect(Collectors.groupingBy (map -> map.get ("service").split ("_")[0],
                               Collectors.reducing ((m1,m2)-> {
                                   Map<String,String> m = new HashMap<>();
                                   m.put("service",m1.get("service")); // you may have to remove the _1 suffix
                                   m.put("storageValue",(Integer)m1.get("storageValue")+(Integer)m2.get("storageValue"));
                                   m.put("users",(Integer)m1.get("users")+(Integer)m2.get("users"));
                                   return m;
                               })));