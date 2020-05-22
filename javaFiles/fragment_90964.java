@XmlRootElement 
public class Bean {
    @XmlElementWrapper(name = "ints")
    @XmlElement(name = "int")
    MyInt[] values;

    // constructors, getters, setters, etc...
}

public class MyInt {
   @XmlAttribute(name="id")
   int id;

   @XmlValue
   int value;
}