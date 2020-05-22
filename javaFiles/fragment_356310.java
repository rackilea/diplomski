@XmlSchema(
        namespace = "http://www.example.eu/test",
        attributeFormDefault = XmlNsForm.QUALIFIED,
        elementFormDefault = XmlNsForm.QUALIFIED,
        xmlns = {
    @XmlNs(
            prefix = "s",
            namespaceURI = "http://www.example.eu/test")
},
        location = "http://www.example.eu/test ResourceSchema.xsd")
package se.example.mavenproject1;

import javax.xml.bind.annotation.XmlNs;
import javax.xml.bind.annotation.XmlNsForm;
import javax.xml.bind.annotation.XmlSchema;