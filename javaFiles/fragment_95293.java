import javafx.scene.layout.VBox;

import javax.xml.bind.JAXB;
import javax.xml.bind.annotation.XmlRootElement;
import java.nio.file.Files;
import java.nio.file.Paths;

class Foo extends VBox {
    private int bar;

    public Foo(int bar) {
        this.bar = bar;
    }

    // To get a Foo back from a XMLfoo
    public Foo(XMLfoo xmLfoo) {
        this.bar = xmLfoo.bar;
    }

    public int getBar() {
        return bar;
    }

    // To convert from Foo to XMLfoo
    public XMLfoo toXML() {
        XMLfoo out = new XMLfoo();
        out.bar = bar;
        return out;
    }
}

@XmlRootElement(name = "Foo")
class XMLfoo {
    public int bar;
}

public class TestFoo {
    public static void main(String[] args) throws Exception {
        JAXB.marshal((new Foo(1)).toXML(), Files.newBufferedWriter(Paths.get("foo.xml")));
        Foo foo = new Foo(JAXB.unmarshal(Files.newBufferedReader(Paths.get("foo.xml")), XMLfoo.class));
    }
}