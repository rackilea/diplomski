public class StudentCourseId implements Serializable{

private static final long serialVersionUID = 1L;
private int studentID;
private int crsID;

public StudentCourseId() {
}

public StudentCourseId(int studentID, int crsID) {
    this.studentID = studentID;
    this.crsID = crsID;
}

public void setStudentID(int studentID) {
    this.studentID = studentID;
}

public int getStudentID() {
    return studentID;
}

public void setCrsID(int crsID) {
    this.crsID = crsID;
}

public int getCrsID() {
    return crsID;
}
public int hashCode() {
    return studentID + crsID;
}

public boolean equals(Object o) {
    return ((o instanceof StudentCourseId)
            && studentID == ((StudentCourseId) o).getStudentID() && crsID == ((StudentCourseId) o)
                .getCrsID());
}
    }
 public int getCrsID() {
    return crsID;
}   
}