String[] keyArray = map.keySet().toArray(new String[map.size()]);
    Set<String> tempSet = new HashSet<String>();
    for (String orginalKeys : keyArray) {
        System.out.println(orginalKeys);
        String newKey = orginalKeys.replace('.', '/');
        if (!newKey.equals(orginalKeys)) {
            map.put(newKey, map.get(orginalKeys));
            tempSet.add(orginalKeys);
            map.remove(orginalKeys);
        }
    }
    System.out.println(map);