private static Map<Integer, List<Element>> group(
        Collection<Element> elements, 
        ChronoField chronoField) {
    return elements.stream().collect(Collectors.groupingBy(
                 x -> x.getDateTime().get(chronoField)));
}