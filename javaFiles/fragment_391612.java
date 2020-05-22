List<String> values = new ObjectMapper().readValue("[\"SKU000001\", \"SKU0000002\", \"SKU0000003\"]",
        List.class);

BasicDBList parsed = new BasicDBList();
values.forEach(s -> parsed.add(s));
assertThat(parsed.size(), is(3));
assertThat(parsed, containsInAnyOrder("SKU000001", "SKU0000002", "SKU0000003"));