class MatchingClass {
    public List<TheEnums> getMatchingEnums(List<String> givenParameters) {

        List<TheEnums> enumsList = Arrays.asList(TheEnums.values());

        return enumsList.stream()
                .filter(e -> givenParameters.containsAll(Arrays.asList(e.getParams())))
                .collect(Collectors.toList());
    }
}