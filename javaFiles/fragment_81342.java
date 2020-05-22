private Map<String, Set<String>> reverseMap(Map<String, String> map) {
        Collection<String> values = map.values();
        Iterator<String> it = values.iterator();
        Map<String, Set<String>> reverseMap = new HashMap<String, Set<String>>();
        while(it.hasNext()) {
            String val = it.next();
            Set<String> set = new HashSet<String>();
            reverseMap.put(val, set);
        }

        Set<String> keys = map.keySet();
        for (String key:keys) {
            String val = map.get(key);
            Set<String> set = reverseMap.get(val);
            set.add(key);
        }
        return reverseMap;
    }