Map<String, Object> m = traversalSource.V().has("request", "id_key", 114).
                                            project('s`,'tik', 'u', 'ts').
                                              by('status').
                                              by('tree_id_key').
                                              by('username')
                                              by('tree_status').
                                            next();        
System.out.println(m.get("s")); 
System.out.println(m.get("tik")); 
System.out.println(m.get("u")); 
System.out.println(m.get("ts"));