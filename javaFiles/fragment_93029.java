public class MySerializer extends JsonSerializer<String> {

  @Override
  public void serialize( String value
                       , JsonGenerator jgen
                       , SerializerProvider provider) throws IOException
                                                           , JsonProcessingException {
    jgen.writeString(MyUtilsClass.formatWithHyphen(value) );
  }

}