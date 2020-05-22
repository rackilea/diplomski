import java.io.File;
import org.simpleframework.xml.Serializer; 
import org.simpleframework.xml.core.Persister;

public static void main(String[] args) throws Exception {

   Foo foo = new Foo();
   Serializer serializer = new Persister(); 
   File result = new File("example.xml"); // XML OUTPUT WILL BE WRITTEN HERE
   serializer.write(foo, result);
}