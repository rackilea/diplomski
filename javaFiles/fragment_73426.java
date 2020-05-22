Map<Long, CsvEntry> entryMap = new TreeMap<Long, CsvEntry>();
// TreeMap so the entries are sorted.
[...]
entryMap.put(nr, new CsvEntry(nr, name, id));
// after populating the map, e.g., after the outer loop
forward(entryMap);