Set<Record> set = new HashSet<>();
for (String org: orgs) {            
    // External service call
    List<Record> result = service.getRecords(org); 
    // Add All to Set (also need to detect duplicates with resulting logic)
    for (Record record: result) {
        if (!set.add(record)) {
            // Handle duplicate by individual record:
            ...
        }
    }
}