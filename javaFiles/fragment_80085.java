private String getTradRequest(String pays){
        String request = "match (n:Translation{trad_country:\""+pays+"\"}) return id(n) as id";
        QueryResult <Map<String,Object>>result = engine.query(request, Collections.EMPTY_MAP);
        Iterator<Map<String, Object>> iterator=result.iterator();
        Map<String,Object> row = iterator.next();
        int id = Integer.valueOf(row.get("id").toString());
        try {
            Document doc = Jsoup.connect("http://10.0.0.1:7474/db/data/node/"+id+"/").get();
            Elements properties = doc.select("th");
            for(int index = 0; index < properties.size(); index++){
                String parameter = properties.get(index).text();
                request = request + ",n."+parameter;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return request;
    }