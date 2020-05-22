HashMap<String,List<HashMap<String, List<String >>>> maps = new HashMap<>();
for (Map.Entry<String, List<HashMap<String, List<String>>>> entry : maps.entrySet()) {
    for (HashMap<String, List<String>> map : entry.getValue()) {
        for (Map.Entry<String, List<String>> subEntry : map.entrySet()) {
            for (String value : subEntry.getValue()) {
                System.out.println(value);
            }
        }
    }
 }