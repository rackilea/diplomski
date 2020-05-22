final String json
        = "[{\"_index\":\"sales_csv\",\"_source\":{\"Order Date\":\"2016-01-28T18:37:00.000Z\"},\"sort\":[1576653361740],\"_score\":null},{\"_index\":\"sales_csv\",\"_source\":{\"Order Date\":\"2016-01-29T18:35:00.000Z\"},\"sort\":[1576653361740],\"_score\":null},{\"_index\":\"sales_csv\",\"_source\":{\"Order Date\":\"2016-01-30T18:41:00.000Z\"},\"sort\":[1576653361739],\"_score\":null},{\"_index\":\"sales_csv\",\"_source\":{\"Order Date\":\"2016-01-30T18:41:00.000Z\"},\"sort\":[1576653361739],\"_score\":null},{\"_index\":\"sales_csv\",\"_source\":{\"Order Date\":\"2016-01-28T18:37:00.000Z\"},\"sort\":[1576653361740],\"_score\":null}]";

final Set<String> result = new HashSet<>();
final com.fasterxml.jackson.databind.JsonNode jsonNode
        = new com.fasterxml.jackson.databind.ObjectMapper()
            .readValue(json, com.fasterxml.jackson.databind.JsonNode.class);
jsonNode.forEach(t -> {
        result.add(t.toString());
    });
result.forEach(System.out::println);