String clusterName = "my-application";
Settings elasticsearchSettings = Settings.builder().put("cluster.name", clusterName).build();
TransportClient client = new PreBuiltTransportClient(elasticsearchSettings)
        .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("localhost"),9300));
Map<String, Object> template_params = new HashMap<>();

// Here is where you put parameters to your script.
template_params.put("param_type", "book");
SearchResponse sr = new SearchTemplateRequestBuilder(client)
        .setScript("template_doctype")  // this is where you specify what template to use
        .setScriptType(ScriptType.FILE)
        .setScriptParams(template_params)
        .setRequest(new SearchRequest())
        .get()
        .getResponse();

SearchHit[] results = sr.getHits().getHits();
for(SearchHit hit : results){

    String sourceAsString = hit.getSourceAsString();
    if (sourceAsString != null) {
        Gson gson = new GsonBuilder().setPrettyPrinting()
                .create();
        Map map = gson.fromJson(sourceAsString, Map.class);
        System.out.println( gson.toJson(map));
    }
}