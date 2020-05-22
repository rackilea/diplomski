import org.eclipse.persistence.oxm.annotations.XmlPath;

public class Foo {

    private String baz;
    private String qux;

    @XmlPath("foo/bar/baz/text()")
    public String getBaz() {
        return baz;
    }

    public void setBaz(final String baz) {
        this.baz = baz;
    }

    @XmlPath("foo/qux/text()")
    public String getQux() {
        return qux;
    }

    public void setQux(final String qux) {
        this.qux = qux;
    }

}