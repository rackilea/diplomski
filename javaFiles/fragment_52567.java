@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Foo{

    public void setA(String a) {
        this.a = a;
    }

    public void setB(String b) {
        this.b = b;
    }

    public String getB (){
       return b;
    }

    public String getA (){
       return a;
    }

    @XmlAttribute(name="atrribB")
    private String b;

    @XmlElement(name="elementA")
    private String a;

}