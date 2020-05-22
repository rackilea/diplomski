import com.example.person.Person;
import javax.xml.bind.JAXB;
import java.io.File;

public class Test {
  public static void main(String[] args) {
    Person p = JAXB.unmarshal(new File("foo.xml"), Person.class);
    System.out.println(p.getName());
    System.out.println(p.getLat());
    System.out.println(p.getLon());
  }
}