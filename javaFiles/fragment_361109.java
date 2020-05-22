package com;


public class UserSerializer extends JsonSerializer<User>{
    private String n;

public UserSerializer(String n){
    this.n = n;
}
@Override
public void serialize(User user, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException, JsonProcessingException {
    if(user != null){
        jsonGenerator.writeStartObject();
        jsonGenerator.writeStringField("name", "Hello, "+user.getName()+" : value of n : "+n);
        jsonGenerator.writeEndObject();
    }
}