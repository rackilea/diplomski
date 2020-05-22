studentsOfThisDept = students.stream()
            .filter(s -> s != null)
            .filter(s -> {
                     Dept dept = s.getDepartment();
                     return dept != null && dept.getCode().equals("CS");
                    })
            .collect(Collectors.toList());