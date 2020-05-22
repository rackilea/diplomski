Map<Integer,Integer> yearCounts = new HashMap<>();

for (Map<String, Integer> year : list_map) {

    if (yearCounts.containsKey(year.get("Year"))) {
        Integer count = yearCounts.get(year.get("Year"));
        yearCounts.put(year.get("Year"), year.get("Cost") + count);
    } else {
        yearCounts.put(year.get("Year"), year.get("Cost"));
    }
}

System.out.println("Year\tCount");

for (Map.Entry<Integer, Integer> yearCount : yearCounts.entrySet()) {
    System.out.println(yearCount.getKey() + "\t" + yearCount.getValue());
}