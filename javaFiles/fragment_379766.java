NamedList<Object> report = (NamedList<Object>)resp.getResponse().get("shards.info");
    Iterator<Map.Entry<String, Object>> coreIterator = report.iterator();
    HashMap<String, String> hm = new HashMap<String, String>(); 
    while(coreIterator.hasNext())
    {
        Map.Entry<String, Object> core = coreIterator.next();
        String core_name=(core.getKey().toString()).replace("abcc","");
        NamedList<Object> report_in = (NamedList<Object>)core.getValue();
        Iterator<Map.Entry<String, Object>> coreIterator_in = report_in.iterator();
        while(coreIterator_in.hasNext()){
            Map.Entry<String, Object> core_in = coreIterator_in.next();
            if(core_in.getKey().equals("numFound"))
            {
                String numFound=core_in.getValue().toString();
                hm.put(core_name, numFound); 
            }
        }
    }