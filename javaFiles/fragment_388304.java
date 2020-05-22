import java.io.File;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.annotate.JsonAutoDetect.Visibility;
import org.codehaus.jackson.map.ObjectMapper;

public class Foo
{
  public static void main(String[] args) throws Exception
  {
    ObjectMapper mapper = new ObjectMapper();
    // configure Jackson to access non-public fields
    mapper.setVisibilityChecker(mapper.getVisibilityChecker().withFieldVisibility(Visibility.ANY));

    // deserialize JSON to instance of Thing
    Thing thing = mapper.readValue(new File("input.json"), Thing.class);

    // look for the target named array2
    if (thing.objects.containsKey("array2"))
    {
      // an element with the target name is present, make sure it's a list/array
      if (thing.objects.get("array2") instanceof List)
      {
        // found it
        List<OtherThing> target = thing.objects.get("array2");
        OtherThing otherThing = target.get(0);
        System.out.println(otherThing.element1); // value1
        System.out.println(otherThing.element2); // value2
        System.out.println(otherThing.element3); // value3
      }
      // else do something
    }
    // else do something
  }
}

class Thing
{
  Map<String, List<OtherThing>> objects;
}

class OtherThing
{
  String element1;
  String element2;
  String element3;
}