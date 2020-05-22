import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Records")
public class StudentGroup {
    private List<Student> students;

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    @XmlElement(name = "StudentRecord")
    public List<Student> getStudents() {
        return students;
    }
}