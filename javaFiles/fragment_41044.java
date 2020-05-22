public static void main(String [] args) throws JsonParseException, JsonMappingException, IOException {
    String str = "[ {\"id\":1,\"type\":\"simple\" }, {\"id\":2,\"type\": {\"kind\":\"simple\" } }, {\"id\":3,\"type\": {\"kind\":\"complex\",\"someOtherThing\":\"value\" } }]";
    ObjectMapper mapper = new ObjectMapper();
    MyObject[] objs = mapper.readValue(str.getBytes(), MyObject[].class);
    for(MyObject obj : objs) {
        System.out.println(obj.id + " " + obj.type.kind + " " + obj.type.someOtherThing);
    }
}

public static class MyObject {
    public String id;
    public Type type;
}

public static class Type {
    public String kind;
    public String someOtherThing;

    public Type() {
    }

    public Type(String kind) {
        this.kind = kind;
    }
}