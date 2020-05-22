import java.io.FileOutputStream;
import java.io.ObjectOuputStream;
public class Test {
    public static void main(String...args) throws Exception {
        Person person = new Person("John Doe");
        System.out.println("Person successfully instantiated with name " + person.getName());

        // now attempt to serialize
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("person.out"));
        out.writeObject(person); // NoClassDefFoundError thrown here if Address.class doesn't exist
        out.close();
    }
}