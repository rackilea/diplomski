private boolean containsText(List<Blocks> blocks) {
    return blocks != null && blocks.stream()
            .map(Blocks::getNames)
            .filter(Objects::nonNull)
            .anyMatch(list -> list.contains("blurb"));
}