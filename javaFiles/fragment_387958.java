for (int i = 0; i < intList.size(); i++) {
    if (ctMap.containsKey(intList.get(i))) {
        ctMap.put(intList.get(i), ctMap.get(intList.get(i)) + 1);
    } else {
        ctMap.put(intList.get(i), 1);
    }
}