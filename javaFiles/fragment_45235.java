class Views {
    public static class ShowSSN {}
}

private static class MyBean{
    @JsonSerialize(using = MyBeanSerializer.class)
    @JsonView(Views.ShowSSN.class)
    String ssn;
    //getter setter constructor
}

private class MyBeanSerializer extends JsonSerializer<String> {
    @Override
    public void serialize(String value, JsonGenerator gen,
                          SerializerProvider serializers) throws IOException {
        Class<?> jsonView =  serializers.getActiveView();
        if (jsonView == Views.ShowSSN.class) 
            gen.writeString(value); // your custom serialization code here
        else 
            gen.writeString("xxx-xx-xxxx");
    }
}