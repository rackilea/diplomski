ObjectMapper objectMapper = new ObjectMapper();
    String json = objectMapper.writeValueAsString(m);
    String id = m.getId();
    IndexRequest indexRequest = new IndexRequest("mediaitems", "mediaitem", m.getId())
            .source(json);

    UpdateRequest updateRequest =
            new UpdateRequest("mediaitems", "mediaitem", m.getId()).upsert(indexRequest);

    //Fix is the line below
    updateRequest.doc(indexRequest); 



    client.update(updateRequest).get();