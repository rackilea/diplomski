.map(entry -> {
     if (entry.getValue().stream.anyMatch(student.name == null)) {
        entry.setValue(entry.getValue().stream().filter(student -> student.name != null).collect(Collectors.toList()));
     }
     return entry;
 })