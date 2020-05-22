import java.util.HashMap;
import java.util.Map;

class SomeType {}
class SomeSubType extends SomeType {}
class SomeOtherType {}

public class CastWarning
{
    public static void main(String[] args)
    {
        Map<SomeSubType, SomeOtherType> originalMap = new HashMap<SomeSubType, SomeOtherType>();
        Map<? extends SomeType, SomeOtherType> map = originalMap;
        Map<SomeType, SomeOtherType> castedMap = (Map<SomeType, SomeOtherType>) map;        

        // Valid because of the cast: The information that the
        // key of the map is not "SomeType" but "SomeSubType"
        // has been cast away...
        SomeType someType = new SomeType();
        SomeOtherType someOtherType = new SomeOtherType();
        castedMap.put(someType, someOtherType);

        // Valid for itself, but causes a ClassCastException
        // due to the unchecked cast of the map
        SomeSubType someSubType = originalMap.keySet().iterator().next();
    }
}