public class CreateStudentsInfo {

public interface StudentsInfo{

    @XBWrite("/studentsInfo/university/@name")
    StudentsInfo setUniversityName(String universityName);

    @XBWrite("/studentsInfo/university/faculty")
    StudentsInfo setFacultyName(String facultyName);

    @XBWrite("/studentsInfo/university/facultyNumber")
    StudentsInfo setFacultyNumber(int facultyNumber);

    @XBWrite("/studentsInfo/university/specialty")
    StudentsInfo setSpecialty(String specialtyName);

    @XBWrite("/studentsInfo/degree")
    StudentsInfo setDegree(int degree);
}

public static void main(String[] args) {        
    StudentsInfo studentsInfo = new XBProjector(Flags.TO_STRING_RENDERS_XML).projectEmptyDocument(StudentsInfo.class);
    studentsInfo.setUniversityName("university name").setFacultyName("faculty name").setFacultyNumber(1234);
    studentsInfo.setSpecialty("speciality name").setDegree(1);
    System.out.println(studentsInfo);
 }
}