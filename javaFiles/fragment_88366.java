List<Map<String,String>> = new ArrayList<HashMap<String,String>>();  
    for (Object row: queryResult)
                    {
                        Map <String, String> map = new HashMap<String, String>();
                        Object[] versionId = (Object [])row;
                        map.put("name", versionId[0]);
                        ... 
                        result.add(map);
                    }