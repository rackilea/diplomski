public HashMap<String, Integer> incrementCountForName(HashMap<String, Integer> hm, String name) {
            if (hm.containsKey(name)) {
                int count = hm.get(name);
                hm.put(name, count + 1);
            } else {
                hm.put(name, 1);
            }
            return hm;
        }