public class ParagraphDeserializer extends JsonDeserializer<Paragraph> {

    @Override
    public Paragraph deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {

        ObjectCodec oc = jsonParser.getCodec();
        JsonNode node = oc.readTree(jsonParser);

        JsonNode text = node.get("text");
        JsonNode paragraphs = text.get("paragraph");

        List<Content> contentList = new ArrayList<Content>();

        for(int i = 0; i < paragraphs.size(); i++) {

            JsonNode p = paragraphs.get(i);

            Content c = new Content();

            String data = "", styleCode = "", content = "";

            try {
                data = p.textValue();
            } catch(Exception ignore) {
            }

            if(data == null) {
                for(int j = 0; j < p.size(); j++) {
                    JsonNode o = p.get(j);

                    try {
                        data = o.textValue();

                        if(data != null) {
                            c.setData(data);
                        }
                    } catch(Exception ignore) {
                    }

                    if(data == null) {
                        styleCode = o.get("styleCode").textValue();
                        content = o.get("content").textValue();
                    }
                }
            } else {
                c.setData(data);
            }

            c.setContent(content);
            c.setStyleCode(styleCode);  

            contentList.add(c);
        }

        Paragraph p = new Paragraph();
        p.setContentList(contentList);
        return p;
    }
}