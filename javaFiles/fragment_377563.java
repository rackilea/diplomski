String jsonresponse = "above json string";
    JsonFactory jsonFactory = new JsonFactory();
    JsonParser jp = jsonFactory.createParser(jsonresponse);
    jp.setCodec(new ObjectMapper());
    JsonNode jsonNode = jp.readValueAsTree();
    JsonNode reportNode = jsonNode.findValue("report");     
    ObjectMapper mapper = new ObjectMapper();
    Report report = mapper.convertValue(reportNode, Report.class);