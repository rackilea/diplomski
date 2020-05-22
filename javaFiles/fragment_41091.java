Map<String,Comparator<Content>> comparatorMap = new HashMap<>();
comparatorMap.put("byCreateDate", Comparator.comparingBy(Content::getData));
comparatorMap.put("byName", Comparator.comparingBy(Content::getName));

public Stream<Content> getSortedContent(String comparatorKey) {
    return getContentList().stream()
        .sorted(comparatorMap.get(comparatorKey));
}