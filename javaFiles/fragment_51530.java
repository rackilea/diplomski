post("/upload",(request, response) -> {     
    final String param1 = request.queryParams("key1");
    final String param2 = request.queryParams("key2");
    // post-process parameters
    // ...
    return "success";
});