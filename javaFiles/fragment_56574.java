import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SortListWithMaps
{
    public static void main(String[] args)
    {
        List<Map<String, String>> list = new ArrayList<Map<String, String>>();

        Map<String, String> action1 = new LinkedHashMap<>();
        action1.put("name", "CreateFirstName");
        action1.put("nextAction", "CreateLastName");

        Map<String, String> action2 = new LinkedHashMap<>();
        action2.put("name", "CreateAddress");
        action2.put("nextAction", "CreateEmail");

        Map<String, String> action3 = new LinkedHashMap<>();
        action3.put("name", "CreateLastName");
        action3.put("nextAction", "CreateAddress");

        Map<String, String> action4 = new LinkedHashMap<>();
        action4.put("name", "CreateEmail");

        list.add(action1);
        list.add(action2);
        list.add(action3);
        list.add(action4);        

        // Make it a bit more interesting...
        Collections.shuffle(list);

        System.out.println("Before sorting");
        for (Map<String, String> map : list)
        {
            System.out.println(map);
        }

        List<Map<String, String>> sortedList = sort(list);

        System.out.println("After sorting");
        for (Map<String, String> map : sortedList)
        {
            System.out.println(map);
        }
    }

    private static List<Map<String, String>> sort(
        List<Map<String, String>> list)
    {
        // Compute a map from "name" to the actual map
        Map<String, Map<String, String>> nameToMap = 
            new LinkedHashMap<String, Map<String,String>>();
        for (Map<String, String> map : list)
        {
            String name = map.get("name");
            nameToMap.put(name, map);
        }

        // Determine the first element for the sorted list. For that,
        // create the set of all names, and remove all of them that
        // appear as the "nextAction" of another entry
        Set<String> names = 
            new LinkedHashSet<String>(nameToMap.keySet());
        for (Map<String, String> map : list)
        {
            String nextAction = map.get("nextAction");
            names.remove(nextAction);
        }
        if (names.size() != 1)
        {
            System.out.println("Multiple possible first elements: " + names);
            return null;
        }

        // Insert the elements, in sorted order, into the result list
        List<Map<String, String>> result = 
            new ArrayList<Map<String, String>>();
        String currentName = names.iterator().next();
        while (currentName != null)
        {
            Map<String, String> element = nameToMap.get(currentName);
            result.add(element);
            currentName = element.get("nextAction");
        }
        return result;
    }
}