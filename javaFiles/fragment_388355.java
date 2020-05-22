@XmlSchema(
    namespace="http://www.mypage.com/schemas/envelope", 
    elementFormDefault=XmlNsForm.QUALIFIED,
    xmlns={
            @XmlNs(namespaceURI = "http://www.mypage.com/schemas/envelope", prefix = ""),
            @XmlNs(namespaceURI = "http://www.mypage.com/schemas/ib", prefix = "ib"),
            @XmlNs(namespaceURI = "http://www.mypage.com/schemas/pdi", prefix = "pdi")
    }
)
@XmlAccessorType(XmlAccessType.FIELD)
package forum14651918;

import javax.xml.bind.annotation.*;