package forum7352753;

import org.eclipse.persistence.oxm.annotations.XmlPath;

class B {
    String x;
    A a;

    public String getX() {
        return x;
    }

    public void setX(String x) {
        this.x = x;
    }

    @XmlPath(".")
    public A getA() {
        return a;
    }

    public void setA(A a) {
        this.a = a;
    }

}