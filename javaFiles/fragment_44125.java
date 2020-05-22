List<List<String>> listOfListValues;
public List<String> getAsFlattenedList() {
    return listOfListValues.stream()
            .map(String::valueOf)
            .collect(toList());
}