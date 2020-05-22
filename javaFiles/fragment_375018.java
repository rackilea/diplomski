import java.lang.reflect.*;
import javax.xml.bind.annotation.*;

public class Demo {

    public static void main(String[] args) throws Exception {
        Field field = Item.class.getDeclaredField("code");
        XmlElement xmlElement = field.getAnnotation(XmlElement.class);
        System.out.println(xmlElement.name());
    }

}