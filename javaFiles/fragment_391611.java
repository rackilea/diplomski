BasicDBObject basicDBObject = BasicDBObject.parse(String.format("{\"a\": %s}",
        "[\"SKU000001\", \"SKU0000002\", \"SKU0000003\"]"));

BasicDBList parsed = (BasicDBList) basicDBObject.get("a");
assertThat(parsed.size(), is(3));
assertThat(parsed, containsInAnyOrder("SKU000001", "SKU0000002", "SKU0000003"));