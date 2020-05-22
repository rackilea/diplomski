class ByAgeAscending implements Comparator<Person> {
    @Override public int compare(Person a, Person b) {
        return a.getAge() < b.getAge();
    }
}

List<Student> students = getSomeStudents();
Collections.sort(students, new ByAgeAscending());