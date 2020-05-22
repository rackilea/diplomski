import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.xml.bind.Binder;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.jaxb.test.Student;
import org.jaxb.test.Students;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

public class JAXBExample {

    public static void main(String[] args) {

        Students students = new Students();
        students.add(new Student(100, "Bob", 29));
        students.add(new Student(101, "John", 19));
        students.add(new Student(102, "Joe", 39));
        students.add(new Student(103, "Jane", 25));

        write(students);
        students = null;
        students = read();

        for (Student student : students) {
            System.out.println(student);
        }

        update();

        students = null;
        students = read();

        for (Student student : students) {
            System.out.println(student);
        }

    }

    public static void write(Students students) {

        System.out.println("----> Write");
        try {

            File file = new File("file.xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(Students.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            // output pretty printed
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            jaxbMarshaller.marshal(students, file);
//            jaxbMarshaller.marshal(students, System.out);

        } catch (JAXBException e) {
            e.printStackTrace();
        }

    }

    public static Students read() {

        System.out.println("----< Read");
        Students students = null;
        try {

            File file = new File("file.xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(Students.class);

            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            students = (Students) jaxbUnmarshaller.unmarshal(file);
            System.out.println(students);

        } catch (JAXBException e) {
            e.printStackTrace();
        }

        return students;

    }

    public static void update() {

        System.out.println("----> Update");
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            File xml = new File("file.xml");
            Document document = db.parse(xml);

            JAXBContext jc = JAXBContext.newInstance(Students.class);

            Binder<Node> binder = jc.createBinder();
            Students students = (Students) binder.unmarshal(document);

            Student student = students.get(0);
            student.setAge(100);

            students.add(new Student(200, "Harry", 65));

            binder.updateXML(students);

            FileOutputStream fos = null;
            try {
                TransformerFactory tf = TransformerFactory.newInstance();
                Transformer t = tf.newTransformer();
                fos = new FileOutputStream(xml);
                t.transform(new DOMSource(document), new StreamResult(fos));
            } catch (TransformerFactoryConfigurationError | TransformerException exp) {
                exp.printStackTrace();
            } finally {
                try {
                    fos.close();
                } catch (Exception e) {
                }
            }
        } catch (ParserConfigurationException | SAXException | IOException | JAXBException exp) {
            exp.printStackTrace();
        }
    }

}