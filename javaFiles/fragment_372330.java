package org.example;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "anElement"
})
@XmlRootElement(name = "root")
public class Root {

    @XmlElement(required = true)
    protected String anElement;

    public String getAnElement() {
        return anElement;
    }

    public void setAnElement(String value) {
        this.anElement = value;
    }

}