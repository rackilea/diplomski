List<Map<String, Integer>> maps = new ArrayList<>();
for (Map.Entry<Integer, List<Tyma>> ee : mapList.entrySet()) {  //looping the output of lambda expression
    Map<String, Integer> mapNew = new HashMap<String, Integer>();
    maps.add(mapNew);
    mapNew.put("year",ee.getKey());
    List<Tyma> li = ee.getValue();

    for (Tyma dept : li) {
        mapNew.put(dept.getTitle(), dept.getAvg());    //getters of Tyma class
    }

}