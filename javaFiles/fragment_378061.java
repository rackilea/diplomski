public class CustomValueSerializer extends JsonSerializer<String> {

   @Override
   public void serialize(String s, JsonGenerator jsonGenerator,
                         SerializerProvider serializerProvider) throws IOException {    

       if(jsonGenerator.getOutputContext().getCurrentName().equals("name")){
          s = getShortName(s);
       }
       jsonGenerator.writeString(s);
   }

   @Override
   public Class<String> handledType() {
       return String.class;
   }

   private String getShortName(String s){
      //make string short
   }
}