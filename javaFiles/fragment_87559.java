import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="catalog")
@XmlAccessorType(XmlAccessType.FIELD)
class catalog {
    @XmlElement(name="course")
    curso course;

    public curso getCourse() {
        return course;
    }

    public void setCourse(curso course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return "catalog [course=" + course + "]";
    }
}

class curso {
    @XmlElement(name = "course_id")
    int course_id;

    @XmlElementWrapper(name = "subjects")
    @XmlElement(name = "subject")
    List<subject> subjects = new ArrayList<>();

    public void setCourse_id(int curso_id) {
        this.course_id = curso_id;
    }

    public void setSubjects(List<subject> subjects) {
        this.subjects = subjects;
    }

    @Override
    public String toString() {
        return "curso [course_id=" + course_id + ", subjects=" + subjects + "]";
    }

}

class subject {
    String subject_id;

    @XmlElement(name = "subject_id")
    public void setSubjectId(String id) {
        this.subject_id = id;
    }

    @Override
    public String toString() {
        return "subject [subject_id=" + subject_id + "]";
    }
}

public class JaxbExample2 {
    public static void main(String[] args) {
        try {

            File file = new File("file.xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(catalog.class);

            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            catalog customer = (catalog) jaxbUnmarshaller.unmarshal(file);
            System.out.println(customer);

        } catch (JAXBException e) {
            e.printStackTrace();
        }

    }
}