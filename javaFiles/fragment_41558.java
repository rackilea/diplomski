public static void main(String[] args)
{
    Attribute a1 = new Attribute();
    a1.id = 1;
    a1.value = 100;
    a1.name = "numericAttribute";
    Attribute a2 = new Attribute();
    a2.id = 2;
    a2.value = 200;
    a2.name = "textAttribute";
    Map<String, Attribute> atts = new HashMap<>();
    atts.put("numeric", a1);
    atts.put("text", a2);
    Key k1 = new Key();
    k1.id = 10;
    k1.name = "key1";
    Key k2 = new Key();
    k2.id = 20;
    k2.name = "key2";
    Data data = new Data();
    data.attributes = new HashMap<>();
    data.attributes.put(k1, atts);
    data.attributes.put(k2, atts);

    ObjectMapper mapper;
    if ("xml".equals(args[0])) {
        mapper = new XmlMapper();
        mapper.registerModule(new XmlModule());
    } else {
        mapper = new ObjectMapper();
    }
    try {
        mapper.writeValue(System.out, data);
    } catch (Exception e) {
        e.printStackTrace();
    }
}