import java.util.ArrayList;

import org.codehaus.jackson.map.ObjectMapper;

public class Foo
{
  public static void main(String[] args) throws Exception
  {
/*
{
    "name": "foo",
    "age": "45",
    "children": [
        {
            "name": "bar",
            "age": "15"
        },
        {
            "name": "baz",
            "age": "10"
        }
    ]
}
 */
    String jsonInput = "{\"name\":\"foo\",\"age\":\"45\",\"children\":[{\"name\":\"bar\",\"age\":\"15\"},{\"name\":\"baz\",\"age\":\"10\"}]}";

    ObjectMapper mapper = new ObjectMapper();
    Parent parent = mapper.readValue(jsonInput, Parent.class);
    System.out.println(mapper.writeValueAsString(parent));
    // output:
    // {"name":"foo","age":45,"children":[{"name":"bar","age":15},{"name":"baz","age":10}]}
  }
}

class Parent
{
  public String name;
  public int age;
  public ArrayList<Child> children = new ArrayList<Child>();
}

class Child
{
  public String name;
  public int age;
}