import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType (XmlAccessType.FIELD)
@XmlRootElement
public class Students implements Iterable<Student> {

    private List<Student> students;

    public Students() {
        this.students = new ArrayList<>(25);
    }

    public Student get(int index) {
        return students.get(index);
    }

    public void add(Student student) {
        students.add(student);
    }

    public void remove(Student student) {
        students.remove(student);
    }

    public int size() {
        return students.size();
    }

    @Override
    public String toString() {
        return "List-o-Students: " + size();
    }

    @Override
    public Iterator<Student> iterator() {
        return students.iterator();
    }

}