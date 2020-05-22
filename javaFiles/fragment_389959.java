Map<Employee, List<Car> map =
    emps.stream()
        .collect(Collectors.toMap(Function.identity(),
                                  Employee::getCars,
                                  (v1,v2)-> {v1.addAll(v2); return v1;},
                                  HashMap::new);