public void serialize(String value, JsonGenerator gen, SerializerProvider serializers) throws IOException, JsonProcessingException {
    String[] str = value.split(",");
    StringBuilder output = new StringBuilder();
    for(int i = 0; i < str.length; i++){
        if(i != 0){
            output.append(',');
        }
        output.append(SearchSerializer.service.encrypt(str[i]));
    }
    gen.writeString(output.toString());
}