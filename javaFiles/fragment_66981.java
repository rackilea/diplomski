Map<String, List<Student>> cleanGroups = list.stream()
      .collect(Collectors.groupingBy(student::no))
      .entrySet().stream()
      .filter(entry -> entry.getValue().size() > 1)
      .map(entry -> {
         entry.setValue(entry.getValue().stream()
                             .filter(student -> student.name != null)
                             .collect(Collectors.toList()));
        return entry;
      })
      .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));