ArrayList<Student> sortedByName;
ArrayList<Student> sortedByGpa;
ArrayList<Student> sortedById;

public List<Student> getStudentByName(String name){
    return binarySearchOnName(sortedByName, name);
}
public List<Student> getStudentByGpa(double gpa){
    return binarySearchOnGpa(sortedByGpa, gpa);
}
...