@XmlSchema(namespace = Namespaces.MAIN,
    xmlns = { @XmlNs(prefix = "xlink", namespaceURI = Namespaces.XLINK) },
    elementFormDefault = QUALIFIED, attributeFormDefault = QUALIFIED)
package example.bindings;

import static javax.xml.bind.annotation.XmlNsForm.QUALIFIED;

import javax.xml.bind.annotation.XmlNs;
import javax.xml.bind.annotation.XmlSchema;
import example.common.Namespaces;