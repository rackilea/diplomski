import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class InnerMapSearch {

    public static void main(String[] args) {
        Map<String, HashMap<String, String>> outer_map = new HashMap<String, HashMap<String, String>>();
        Map<String, String> inner_map = new HashMap<String, String>();

        String[] searchParams = {"blabla1", "blabla3", "blabla20"};

        //Populating the map
        int reader = 1;
        while (reader < 10) {
            String nameAsKey1 = "blabla" + reader; // value1
            inner_map.put("name", nameAsKey1);

            String surnameAsKey2 = "blabla" + reader; // value2
            inner_map.put("surname", surnameAsKey2);

            outer_map.put(String.valueOf(reader), (HashMap<String, String>) inner_map);
            inner_map = new HashMap<String, String>();
            reader++;
        }

        //Searching
        Set<String> searchResults = new HashSet<String>(); // Using set to avoid duplicate

        // Iterate over the outer map
        for(String key : outer_map.keySet()){
            // Iterate through each inner_map value of outer map
            for(Entry<String, String> innerEntry : outer_map.get(key).entrySet()){
                // Iterate through the list of search params and see if its present in inner_hashmap
                for(String searchParam : searchParams){
                    if(searchParam.equals(innerEntry.getValue())){
                        // The search parameter is in inner map so adding to result.
                        searchResults.add(searchParam);
                    }
                }
            }
        }

        // Converting the list to an array.
        String[] searchResultsArray = searchResults.toArray(new String[searchResults.size()]);
    }

}