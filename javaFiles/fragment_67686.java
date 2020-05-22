HashSet<String> keys = new HashSet<>();
        for (Entry<String, HashMap<String, List<Integer>>> entry : COOLMAP.entrySet()) {
            for (Entry<String, List<Integer>> innerEntry : entry.getValue().entrySet()) {
                String innerKey = innerEntry.getKey();
                keys.add(innerKey);
            }