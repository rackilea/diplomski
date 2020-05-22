import java.io.IOException;

import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.Version;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializerProvider;
import org.codehaus.jackson.map.module.SimpleModule;

public class Foo
{
  public static void main(String[] args) throws Exception
  {
    ObjectMapper mapper = new ObjectMapper();
    System.out.println(mapper.writeValueAsString(new Bar()));
    // output: {"bytes":"AQIDBAUGBwgJCgsMDQ4PEA=="}

    SimpleModule module = new SimpleModule("byte[] as integers", Version.unknownVersion());
    module.addSerializer(byte[].class, new ByteArrayAsIntegersSerializer());
    mapper = new ObjectMapper().withModule(module);
    System.out.println(mapper.writeValueAsString(new Bar()));
    // output: {"bytes":"AQIDBAUGBwgJCgsMDQ4PEA=="}
    // ByteArrayAsIntegersSerializer was not used!

    module = new SimpleModule("byte[] as integers 2", Version.unknownVersion());
    module.addSerializer(Bar.class, new BarSerializer());
    mapper = new ObjectMapper().withModule(module);
    System.out.println(mapper.writeValueAsString(new Bar()));
    // output: {"bytes":[1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16]}
  }
}

class Bar
{
  public byte[] bytes = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16};
}

class BarSerializer extends JsonSerializer<Bar>
{
  @Override
  public void serialize(Bar value, JsonGenerator jgen, SerializerProvider provider) 
      throws IOException, JsonProcessingException
  {
    jgen.writeStartObject();
    jgen.writeFieldName("bytes");
    jgen.writeStartArray();
    for (byte b : value.bytes)
      jgen.writeNumber(b);
    jgen.writeEndArray();
    jgen.writeEndObject();
  }
}

class ByteArrayAsIntegersSerializer extends JsonSerializer<byte[]>
{
  @Override
  public void serialize(byte[] bytes, JsonGenerator jgen, SerializerProvider provider) 
      throws IOException, JsonProcessingException
  {
    jgen.writeStartArray();
    for (byte b : bytes)
      jgen.writeNumber(b);
    jgen.writeEndArray();
  }
}