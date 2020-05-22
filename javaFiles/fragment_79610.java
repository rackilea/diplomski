package com.example;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "elementName"
})
@XmlRootElement(name = "Root")
public class Root
    implements Serializable
{

    @XmlElement(name = "ElementName", required = true)
    protected MyEnumType elementName;

    public MyEnumType getElementName() {
        return elementName;
    }

    public void setElementName(MyEnumType value) {
        this.elementName = value;
    }

    public boolean isSetElementName() {
        return (this.elementName!= null);
    }

}