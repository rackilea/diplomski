final List<Grouping<Object, Map.Entry<Employee, Department>>> result =
  new ArrayList<Grouping<Object, Map.Entry<Employee, Department>>>();
Linq4j.asEnumerable(empDepts.entrySet())
    .groupBy(
        new Function1<Map.Entry<Employee, Department>, Object>() {
          public Object apply(Map.Entry<Employee, Department> entry) {
            return entry.getValue();
          }
        })
    .into(result);