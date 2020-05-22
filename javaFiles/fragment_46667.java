client.admin().indices().create(new CreateIndexRequest("facebook")).actionGet();

 XContentBuilder mapping = jsonBuilder()
                              .startObject()
                                   .startObject("doctype")
                                        .startObject("properties")
                                            .startObject("content")
                                                .field("type", "completion")
                                             .endObject()
                                        .endObject()
                                    .endObject()
                                 .endObject();

  PutMappingResponse putMappingResponse = client.admin().indices()
                .preparePutMapping("facebook")
                .setType("doctype")
                .setSource(mapping)
                .execute().actionGet();