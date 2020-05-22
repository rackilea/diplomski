package forum9862100;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlJavaTypeAdapter(ChildAdapter.class)
@XmlAccessorType(XmlAccessType.FIELD)
public class Child {

    protected String id;
    protected String foo;
    protected Integer bar;

}