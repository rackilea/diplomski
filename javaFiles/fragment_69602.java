import java.util.*;
import javax.xml.bind.annotation.*;
import javax.xml.datatype.XMLGregorianCalendar;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Foo {

    private Date date;
    private Calendar cal;
    private XMLGregorianCalendar xgc;

}