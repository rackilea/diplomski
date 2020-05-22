@XmlSchema(
    elementFormDefault=XmlNsForm.QUALIFIED,
    namespace="http://www.forum-datenaustausch.ch/invoice",
    xmlns={
        @XmlNs(prefix="invoice", namespaceURI="http://www.forum-datenaustausch.ch/invoice"),
        @XmlNs(prefix="ds", namespaceURI="http://www.w3.org/2000/09/xmldsig#"),
        @XmlNs(prefix="xenc", namespaceURI="http://www.w3.org/2001/04/xmlenc#")
    }
)
package forum16559889;

import javax.xml.bind.annotation.*;