class CompareStudentNames implements Comparator<Student> {

//Sorts the students by name ignoring case.
@Override
public int compare(Student o1, Student o2) {
    String name1 = o1.getName();
    String name2 = o2.getName();

    return name1.compareToIgnoreCase(name2);
}