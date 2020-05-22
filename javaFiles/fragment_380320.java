import java.io.IOException;

import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.Version;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.JsonDeserializer;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.module.SimpleModule;

public class Foo
{
  public static void main(String[] args) throws Exception
  {
    TestBean bean = new TestBean();
    bean.value = 42L;

    ObjectMapper mapper = new ObjectMapper();

    String beanJson = mapper.writeValueAsString(bean);
    System.out.println(beanJson);
    // output: {"value":42}

    TestBean beanCopy1 = mapper.readValue(beanJson, TestBean.class);
    System.out.println(beanCopy1.value);
    // output: 42

    SimpleModule module =
      new SimpleModule("LongDeserializerModule",
          new Version(1, 0, 0, null));
    module.addDeserializer(Long.class, new LongJsonDeserializer());

    mapper = new ObjectMapper();
    mapper.registerModule(module);

    TestBean beanCopy2 = mapper.readValue(beanJson, TestBean.class);
    System.out.println(beanCopy2.value);
    // output: 126
  }
}

class TestBean
{
  Long value;
  public Long getValue() {return value;}
  public void setValue(Long value) {this.value = value;}
}

class LongJsonDeserializer extends JsonDeserializer<Long>
{
  @Override
  public Long deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException
  {
    Long value = jp.getLongValue();
    return value * 3;
  }
}