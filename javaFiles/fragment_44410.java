ArrayNode arrayNode = (ArrayNode) mapper.readTree(this.getScrape().getScrapetext());

    A a = mapper.readValue(arrayNode.get(0), A.class);

    arrayNode.remove(0);

    List<B> b = mapper.readValue(arrayNode.toString(), new TypeReference<List<B>>()
    {
    });