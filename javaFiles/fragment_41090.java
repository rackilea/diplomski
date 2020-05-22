Map<String,List<Content>> contents = new HashMap<>();
contents.put("first", getMyContents());

public Stream<Content> getMySortedContent(Comparator comparator) {
    return contents.get("first").sorted(comparator);
}