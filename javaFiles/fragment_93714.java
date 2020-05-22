import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class B extends A {

    private C c;

    @Override
    public C getC() {
        return c;
    }

    @Override
    public void setC(C c) {
        this.c = c;
    }

}