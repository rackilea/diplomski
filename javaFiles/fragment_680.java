IndexResponse response = client.prepareIndex("twitter", "tweet", "1")
    .setSource(jsonBuilder()
                .startObject()
                    .field("user", "kimchy")
                    .field("postDate", new Date())
                    .field("message", "trying out Elasticsearch")
                .endObject()
              )
    .get();