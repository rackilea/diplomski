Map<Instant, String> getItems() {
    return items.entrySet()
            .stream()
            .collect(Collectors.toMap(
                    Map.Entry::getKey,
                    e -> renderTags(e.getValue())));
}