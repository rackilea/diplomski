for (Map.Entry<Integer,Integer> entry : map1.entrySet()) {
    for (Integer value : map2.values()) {
        if (value.equals(entry.getKey())) {
            entry.setValue(entry.getValue()+1);
        }
    }
}