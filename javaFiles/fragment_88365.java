URIBuilder builder = new URIBuilder()
            .setScheme("http")
            .setHost("localhost:9090")
            .setPath("warehouse-ui/api/v2/external-file/"+context.get("descriptor").toString())
            .setParameter("businessUnit", context.get("businessUnit").toString())
            .setParameter("sourceSystem", context.get("sourceSystem").toString())
            .setParameter("effectiveFrom", context.get("effectiveFrom").toString())
            .setParameter("effectiveTo", context.get("effectiveTo").toString())
            .setParameter("threshold", context.get("threshold").toString());

    String encoding = Base64.getEncoder().encodeToString((usernamePasswordPair).getBytes());
    File isF = new File(pathToFile);
    FileInputStream fis = null;
    fis = new FileInputStream(isF);

    HttpPut request = new HttpPut(builder.toString());
    HttpEntity entity = MultipartEntityBuilder.create().addPart("file", new InputStreamBody(fis, isF.getName())).build();
    request.setHeader("Authorization", "Basic " + encoding);
    request.setEntity(entity);
    HttpClient client = HttpClientBuilder.create().build();
    HttpResponse response = client.execute(request);
    int code = response.getStatusLine().getStatusCode();
    System.out.println(code);
    System.out.println(response.getStatusLine().getReasonPhrase());