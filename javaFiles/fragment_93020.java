import java.io.File;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.map.ObjectMapper;

public class Foo
{
  String value;

  public String getValue() {return value;}
  public void setValue(String value) {this.value = value;}
  public void setValue(int value) {this.value = String.valueOf(value);}

  public static void main(String[] args) throws Exception
  {
    ObjectMapper mapper = new ObjectMapper();
    mapper.getDeserializationConfig().addMixInAnnotations(Foo.class, IgnoreFooSetValueIntMixIn.class);
    Foo foo = mapper.readValue(new File("input.json"), Foo.class);
    System.out.println(mapper.writeValueAsString(foo));
  }
}

abstract class IgnoreFooSetValueIntMixIn
{
  @JsonIgnore public abstract void setValue(int value);
}