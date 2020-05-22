@Test
public void test2() throws JsonParseException, JsonMappingException, IOException {
    ObjectMapper mapper = new XmlMapper();
    SomeRootObject object=mapper.readValue("<SomeRootObject><Events><Event><EventID>248739296</EventID><Event>1709</Event></Event><Event><EventID>248739297</EventID><Event>1710</Event></Event></Events></SomeRootObject>", SomeRootObject.class);
    System.out.println(toString(object));
}