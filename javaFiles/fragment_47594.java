public class Main {

    public enum MyEnum {
        enumValue1
    }

    public static void main(String[] args) throws IOException {
        ObjectMapper mapper = new ObjectMapper();

        MyClass obj = new MyClass();
        obj.setContext(new HashMap<String, Object>());

        obj.setVal1("foo");
        obj.setVal2("var");
        obj.getContext().put("key1", "stringValue1");
        obj.getContext().put("key2", MyEnum.enumValue1);
        obj.getContext().put("key3", 3.0);

        mapper.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(obj);

        System.out.println(json);

        MyClass readValue = mapper.readValue(json, MyClass.class);
        //Check the enum value was correctly deserialized
        Assert.assertEquals(readValue.getContext().get("key2"), MyEnum.enumValue1);
    }

}