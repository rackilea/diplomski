@XmlRootElement
public class Foo{

    public void setA(String a) {
        this.a = a;
    }

    public void setB(String b) {
        this.b = b;
    }

    @XmlAttribute(name="atrribB")
    public String getB (){
       return b;
    }

    @XmlElement(name="elementA")
    public String getA (){
       return a;
    }

    private String b;

    private String a;

}