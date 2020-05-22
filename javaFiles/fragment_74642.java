@Override
public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Student)) return false;

    Student student = (Student) o;

    if (name != null ? !name.equals(student.name) : student.name != null) return false;
    if (gender != null ? !gender.equals(student.gender) : student.gender != null) return false;
    if (studentID != null ? !studentID.equals(student.studentID) : student.studentID != null) return false;
    return !(degreeProgramme != null ? !degreeProgramme.equals(student.degreeProgramme) : student.degreeProgramme != null);
}