String json = "{}";
PutMappingResponse response = client.admin().indices()
                    .preparePutMapping(index)
                    .setType(type)
                    .setSource(json)
                    .execute().actionGet();