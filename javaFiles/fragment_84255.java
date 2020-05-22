Map<String, List<Object>> m = traversalSource.V().has("request", "id_key", 114).
                                                  valueMap().next();        
System.out.println(m.get("status").get(0)); 
System.out.println(m.get("tree_id_key").get(0)); 
System.out.println(m.get("username").get(0)); 
System.out.println(m.get("tree_status").get(0));