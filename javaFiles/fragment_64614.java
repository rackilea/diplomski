public void applyFilters() {
    listOfLabels.forEach(label -> label.setVisible(false));
    listOfLabels.stream()
        .filter(label -> filters.stream()
            .allMatch(predicate -> predicate.test(label)))
        .forEach(label -> label.setVisible(true));
}