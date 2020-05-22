import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JacksonFoo
{
  public static void main(String[] args) throws Exception
  {
    // {"var1":"some_value", "var2":"some_other_value"}
    String jsonInput = "{\"var1\":\"some_value\", \"var2\":\"some_other_value\"}";

    ObjectMapper mapper = new ObjectMapper().setVisibility(PropertyAccessor.FIELD, Visibility.ANY);

    A a = new A(new Foo("some_value"), "some_other_value");
    System.out.println(mapper.writeValueAsString(a));
    // output: {"var1":"some_value","var2":"some_other_value"}

    A aCopy = mapper.readValue(jsonInput, A.class);
    System.out.println(mapper.writeValueAsString(aCopy));
    // output: {"var1":"some_value","var2":"some_other_value"}
  }
}

class Foo
{
  private final String var1;

  Foo(String var1) {this.var1 = var1;}

  private Foo() {this.var1 = null;}
}

class A
{
  @JsonUnwrapped
  private final Foo foo;
  private final String var2;

  A(Foo foo, String var2)
  {
    this.foo = foo;
    this.var2 = var2;
  }

  private A()
  {
    this.foo = null;
    this.var2 = null;
  }
}