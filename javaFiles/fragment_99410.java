Map<String, Record> map = new HashMap<String, Record> ();

addRecord(map, someRecord);

private void addRecord(Map<String, Record> map, Record record) {
    Record inMap = map.get(record.getCountryName());
    if (inMap == null) {
        inMap = record;
    } else {
        inMap.setNumberOfDays(inMap.getNumberOfDays() + record.getNumberOfDays());
    }
    map.put(record.getCountryName(), inMap);
}