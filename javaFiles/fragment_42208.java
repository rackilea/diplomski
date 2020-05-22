//Deserialisation
ObjectMapper mapper = new ObjectMapper();
Map<String, Object> dataMap = (Map<String, Object>) mapper.readValue("{\"dataset\":{\"id\":19701916,\"column_names\":[\"Date\",\"Cash Buyer\",\"Cash Seller Settlement\",\"3-months Buyer\",\"3-months Seller\",\"15-months Buyer\",\"15-months Seller\",\"Dec 1 Buyer\",\"Dec 1 Seller\",\"Dec 2 Buyer\",\"Dec 2 Seller\",\"Dec 3 Buyer\",\"Dec 3 Seller\"],\"frequency\":\"daily\",\"type\":\"Time Series\",\"premium\":false,\"limit\":null,\"transform\":null,\"column_index\":null,\"start_date\":\"2012-01-03\",\"end_date\":\"2017-06-14\",\"data\":[[\"2017-06-14\",5684.0,5684.5,5715.0,5717.0,null,null,5780.0,5790.0,5790.0,5800.0,5790.0,5800.0],[\"2017-06-13\",5658.0,5659.0,5692.0,5693.0,null,null,5750.0,5760.0,5765.0,5775.0,5760.0,5770.0],[\"2017-06-12\",5751.0,5752.0,5782.0,5783.0,null,null,5835.0,5845.0,5850.0,5860.0,5845.0,5855.0]]}}", Map.class);
System.out.println(transform((Map<String, Object>)dataMap.get("dataset")));


//Transformation

private static List<Map<String,Object>> transform (Map<String, Object> dataMap){
    List<Map<String,Object>> result = new ArrayList<>();
    List<String> columns = (List<String>) dataMap.get("column_names");
    List<List<Object>> data = (List<List<Object>>) dataMap.get("data");

    for(List<Object> dataElement : data){
        Map<String, Object> element = new HashMap<>();
        for(int i = 0 ; i < dataElement.size() ; i++){
            element.put(columns.get(i), dataElement.get(i));
        }
        result.add(element);
    }

    return result;
}