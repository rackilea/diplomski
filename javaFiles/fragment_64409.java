import java.io.*;
import java.nio.file.*;
import java.util.*;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JacksonTest
{
    public static void main(String[] args) {
        try (InputStream is = Files.newInputStream(Paths.get("C:/temp/test.json"))) {
            ObjectMapper mapper = new ObjectMapper();
            // deserialize json into map
            Map<String, Object> map = (Map<String, Object>)mapper.readValue(is, Map.class);
            putCollectionNamesInsideEntries(map);
            // serialize map into json
            mapper.writeValue(System.out, map);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void putCollectionNamesInsideEntries(Map<String, Object> map) {
        // get root "entities" entry
        Map<String, Object> entitiesMap = (Map<String, Object>)map.get("entities");
        for (Map.Entry<String, Object> entitiesEntry : entitiesMap.entrySet()) {
            // iterate over collection entries
            if (entitiesEntry.getValue() instanceof Collection) {
                Collection coll = (Collection)entitiesEntry.getValue();
                // iterate over entries in collection
                for (Object collEntry : coll) {
                    if (collEntry instanceof Map) {
                        // add "name" with ame of collection (key entry under "entries")
                        ((Map<String, Object>)collEntry).put("name", entitiesEntry.getKey());
                    }
                }
            }
        }
    }
}