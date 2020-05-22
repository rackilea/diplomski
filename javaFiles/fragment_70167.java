Map<String, Integer> map = studentList.stream()
        .collect(Collectors.toMap(
                        student->student.getStudentName().toLowerCase(),
                        Student::getMarks,
                        (s1,s2) -> s1 +s2, // add values when merging
                        LinkedHashMap::new
                ));