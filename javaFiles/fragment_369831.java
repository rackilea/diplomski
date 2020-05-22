package org.example;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "root", propOrder = {
    "powerUnit"
})
public class Root {

    @XmlElement(name = "power-unit", required = true)
    protected String powerUnit;

    public String getPowerUnit() {
        return powerUnit;
    }

}