package org.example;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "anElement"
})
@XmlRootElement(name = "root")
public class Root {

    @XmlElementRef(name = "anElement", namespace = "http://www.example.org", type = JAXBElement.class)
    protected JAXBElement<String> anElement;

    public JAXBElement<String> getAnElement() {
        return anElement;
    }

    public void setAnElement(JAXBElement<String> value) {
        this.anElement = ((JAXBElement<String> ) value);
    }

}