package forum13872065;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.datatype.XMLGregorianCalendar;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Root {

    @XmlElement(name = "Month")
    @XmlSchemaType(name = "gMonth")
    @XmlJavaTypeAdapter(GMonthAdapter.class)
    protected XMLGregorianCalendar month;

}