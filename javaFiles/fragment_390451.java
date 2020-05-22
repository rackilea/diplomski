public class Test {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        Map<String, List<String>> tagMap = new HashMap<>();
        // Populate the list
        list.add("A7750 0.0 28.30");
        list.add("A7750 0.3 28.30");
        list.add("A7741 0.0 31.40");
        list.add("A7741 0.1 31.40");
        list.add("A7752 0.5 31.40");
        list.add("A7752 0.7 31.40");

        // Loop through all the entries
        for (String entry : list) {
            // Split on space to get the tag
            String tag = entry.split(" ")[0];
            // Get the list of data starting with this tag
            List<String> tagList = tagMap.get(tag);
            if (tagList == null) {
                // If there are no other entries for tag yet, add a
                // new list to the map
                tagList = new ArrayList<>();
                tagMap.put(tag, tagList);
            }
            // Add the current entry to the list
            tagList.add(entry);
        }

        // Print out the results
        for (Map.Entry<String, List<String>> entry : tagMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}