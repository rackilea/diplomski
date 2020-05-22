public List<Person> getPersByDept(String dept) {
   return persList.values().stream()
             .filter(person-> Objects.nonNull(person.dept))
             .filter(person -> Objects.equals(person.dept.id, dept))
             .collect(Collectors.toList());
}