// Groups students by group number
Map<String, List<Student>> allGroups = list.stream().collect(Collectors.groupingBy(student::no));
// Filters groups that have more than 1 member
Map<String, List<Student>> filteredGroups = allGroups.entrySet().stream().filter(entry -> entry.getValue().size() > 1).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
// Removes all non-null members
Map<String, List<Student>> cleanGroups = filteredGroups.entrySet().stream()
    .map(entry -> {
        entry.setValue(entry.getValue().stream().filter(student -> student.name != null).collect(Collectors.toList()));
        return entry;
    }).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));