List<String> VALUE_METRIC_KEYS = Arrays.asList("bugs");
ComponentWsRequest componentWsRequest = new ComponentWsRequest();
componentWsRequest.setComponentKey(resourceKey);
componentWsRequest.setMetricKeys(VALUE_METRIC_KEYS);
ComponentWsResponse componentWsResponse = wsClient.measures().component(componentWsRequest);
List<Measure>measureList = componentWsResponse.getComponent().getMeasuresList();
for(Measure measure : measureList){
       System.out.println(measure);
}