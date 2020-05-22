public Collection<Student> findStudents(String filter) {
  Iterable<Student> filteredStudents = Iterables.filter(listOfStudents, new Predicate<Student>() {
    @Override
    public boolean apply(Student student) {
      return student.getName().contains(filter);
    }
  }
}
return Lists.newArrayList(filteredStudents);