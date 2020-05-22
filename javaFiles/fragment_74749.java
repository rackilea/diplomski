Map<String, Student> newStudentMap = studentMap.entrySet().stream().collect(Collectors.toMap(
    Map.Entry::getKey, 
    e -> Student.builder()
           .name(e.getValue().get("name"))
           .email(e.getValue().get("email"))
           .phone(e.getValue().get("phone"))
           .build()
    ));