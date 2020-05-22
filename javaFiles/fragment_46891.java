import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import org.jaxb.test.Student;
import org.jaxb.test.Students;

public class JAXBExample {

    public static void main(String[] args) {

        Students students = new Students();
        students.add(new Student(100, "Bob", 29));
        students.add(new Student(101, "John", 19));
        students.add(new Student(102, "Joe", 39));
        students.add(new Student(103, "Jane", 25));

        try {

            File file = new File("file.xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(Students.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            // output pretty printed
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            jaxbMarshaller.marshal(students, file);
            jaxbMarshaller.marshal(students, System.out);

        } catch (JAXBException e) {
            e.printStackTrace();
        }
        try {

            File file = new File("file.xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(Students.class);

            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            students = (Students) jaxbUnmarshaller.unmarshal(file);
            System.out.println(students);

        } catch (JAXBException e) {
            e.printStackTrace();
        }

    }

}