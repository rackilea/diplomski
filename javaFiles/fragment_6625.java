Set<Record> set = new HashSet<>();
Set<Record> duplicates = new HashSet<>();
for (String org: orgs) {            
    // External service call
    List<Record> result = service.getRecords(org); 
    // Add All to Set (also need to detect duplicates with resulting logic)
    Set<Record> duplicateResult = new .HashSet<>(result);
    duplicateResult.retainAll(set);
    duplicates.addAll(duplicateResult);
    set.addAll(result);
}
for (Record record: duplicates) {
    // Handle duplicate once:
    ...
}