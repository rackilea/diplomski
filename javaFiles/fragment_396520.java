String filePath = "D:\\\\1SearchEngine\\testing.pdf";
String encodedfile = null;
RestHighLevelClient restHighLevelClient = null;
File file = new File(filePath);
try {
    FileInputStream fileInputStreamReader = new FileInputStream(file);
    byte[] bytes = new byte[(int) file.length()];
    fileInputStreamReader.read(bytes);
    encodedfile = new String(Base64.getEncoder().encodeToString(bytes));
} catch (FileNotFoundException e) {
    e.printStackTrace();
}

try {
    if (restHighLevelClient != null) {
        restHighLevelClient.close();
    }
} catch (final Exception e) {
    System.out.println("Error closing ElasticSearch client: ");
}

try {
    restHighLevelClient = new RestHighLevelClient(RestClient.builder(new HttpHost("localhost", 9200, "http"),
            new HttpHost("localhost", 9201, "http")));
} catch (Exception e) {
    System.out.println(e.getMessage());
}


Map<String, Object> jsonMap = new HashMap<>();
jsonMap.put("Name", "Karthikeyan");
jsonMap.put("postDate", new Date());
jsonMap.put("resume", encodedfile);

IndexRequest request = new IndexRequest("attach_local", "doc", "104")
        .source(jsonMap)
        .setPipeline("attach_local");

try {
    IndexResponse response = restHighLevelClient.index(request);
} catch(ElasticsearchException e) {
    if (e.status() == RestStatus.CONFLICT) {

    }
}