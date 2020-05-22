String mapping = XContentFactory.jsonBuilder().startObject().startObject(typeName).startObject("properties")
                    .startObject("location").field("type", "geo_point").endObject()
                    .startObject("language").field("type", "string").field("index", "not_analyzed").endObject()
                    .startObject("user").startObject("properties").startObject("screen_name").field("type", "string").field("index", "not_analyzed").endObject().endObject().endObject()
                    .startObject("mention").startObject("properties").startObject("screen_name").field("type", "string").field("index", "not_analyzed").endObject().endObject().endObject()
                    .startObject("in_reply").startObject("properties").startObject("user_screen_name").field("type", "string").field("index", "not_analyzed").endObject().endObject().endObject()
                    .startObject("retweet").startObject("properties").startObject("user_screen_name").field("type", "string").field("index", "not_analyzed").endObject().endObject().endObject()
                    .endObject().endObject().endObject().string();
client.admin().indices().preparePutMapping(indexName).setType(typeName).setSource(mapping).execute().actionGet();