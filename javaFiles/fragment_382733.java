package forum14582017;

import java.util.*;
import javax.xml.bind.annotation.*;
import javax.xml.namespace.QName;
import org.w3c.dom.Element;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {"callReport7"})
@XmlRootElement(name = "response")
public class Response {

    @XmlElement(required = true)
    protected Response.CallReport7 callReport7;

    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {"response"})
    public static class CallReport7 {

        @XmlElement(required = true)
        protected Response.CallReport7 .CallReport7Response response;

        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {"any"})
        public static class CallReport7Response {

            @XmlAnyElement
            protected List<Element> any;
            @XmlAttribute(name = "time")
            protected String time;
            @XmlAnyAttribute
            private Map<QName, String> otherAttributes = new HashMap<QName, String>();

        }

    }

}