@Test
public void test1() throws JsonParseException, JsonMappingException, IOException {
    ObjectMapper mapper = new XmlMapper();
    List<Event> event=mapper.readValue("<Events><Event><EventID>248739296</EventID><Event>1709</Event></Event><Event><EventID>248739297</EventID><Event>1710</Event></Event></Events>", new TypeReference<List<Event>>() {
    });
    System.out.println(toString(event));
}

public String toString(Object obj) {
    try {
        StringWriter w = new StringWriter();
        new ObjectMapper().configure(SerializationFeature.INDENT_OUTPUT, true).writeValue(w, obj);
        return w.toString();
    } catch (Exception e) {
        throw new RuntimeException(e);
    }
}