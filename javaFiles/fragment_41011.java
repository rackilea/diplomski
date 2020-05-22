import java.io.*;
import javax.xml.bind.*;
import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.*;

@XmlType
class Valued {
    @XmlAttribute(name="value")
    public String value;
}

class ValuedAdapter extends XmlAdapter<Valued, String> {
    public Valued marshal(String s) {
        Valued v = new Valued();
        v.value = s;
        return v;
    }
    public String unmarshal(Valued v) {
        return v.value;
    }
}

@XmlRootElement
class Person {

    @XmlJavaTypeAdapter(ValuedAdapter.class)
    @XmlElement
    String firstName;

    @XmlJavaTypeAdapter(ValuedAdapter.class)
    @XmlElement
    String lastName;

}

class SO12928971 {
    public static void main(String[] args) throws Exception {
        Person p = new Person();
        p.firstName = "John";
        p.lastName = "Doe";
        JAXBContext jc = JAXBContext.newInstance(Person.class);
        StringWriter sw = new StringWriter();
        jc.createMarshaller().marshal(p, sw);
        String xml = sw.toString();
        System.out.println(xml);
        StringReader sr = new StringReader(xml);
        p = (Person)jc.createUnmarshaller().unmarshal(sr);
        assert "John".equals(p.firstName);
        assert "Doe".equals(p.lastName);
    }
}