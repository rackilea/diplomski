Map<String,Supplier<List<Content>>> supplierMap = new HashMap<>();
supplierMap.put("unsorted", this::unsortedList);
supplierMap.put("sorted_by_date" this::sortedByDate);

public List<Content> getContents(String supplierKey) {
    return supplierMap.get(supplierKey).get();
}

private List<Content> unsortedList() {
    return contentsList;
}

private List<Content> sortedByDate() {
    Collections.sort(contentsList, Comparator.comparingBy(Content::getDate));
    return contentsList;
}