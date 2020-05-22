for (String key : ungroupedCsv.keySet()) {
    String date = dateOnly.format(dateTime.parse(key));
    if (! grouped.containsKey(date)) {
        grouped.put(date, new ArrayList<Double>());
    }
    grouped.get(date).add(ungroupedCsv.get(key));
}
System.out.println(grouped);