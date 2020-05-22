public class MyTest {

    @Test
    public void testJson() throws IOException {
        final String json = getJson();
        final JsonNode jsonDocumentNode = new ObjectMapper().readTree(json);
        final List<String> fields = getDocumentFields((ObjectNode) jsonDocumentNode);
        assertThat(fields, Matchers.contains("#field1", "#field2", "field1", "field2", "field3", "panel_field"));
    }

    public static String getJson() {
        return "{\r\n" +
                "     \"Header\":{\r\n" +
                "       \"sub-header1\":{\r\n" +
                "          \"#field1\":\"value\",\r\n" +
                "          \"#field2\":\"value\"\r\n" +
                "       },\r\n" +
                "       \"sub-header2\":{\r\n" +
                "          \"field1\":\"\",\r\n" +
                "          \"field2\":\"\",\r\n" +
                "          \"field3\":\"\",\r\n" +
                "          \"panel_field\":{\r\n" +
                "            \"value1\":\"\",\r\n" +
                "            \"value2\":\"\"\r\n" +
                "         }\r\n" +
                "      }          \r\n" +
                "   }\r\n" +
                "}";
    }

    public static List<String> getDocumentFields(final ObjectNode jsonDocumentNode) {
        final List<String> documentFields = new ArrayList<>();
        for (final JsonNode header : (Iterable<JsonNode>) jsonDocumentNode::elements) {
            for (final JsonNode subheader : (Iterable<JsonNode>) header::elements) {
                for (final Map.Entry<String, JsonNode> field : (Iterable<Map.Entry<String, JsonNode>>) subheader::fields) {
                    documentFields.add(field.getKey());
                }
            }
        }
        return documentFields;
    }
}