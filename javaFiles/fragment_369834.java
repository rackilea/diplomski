package org.example;

import javax.xml.bind.annotation.*;

@XmlType(name = "PowerUnit")
@XmlEnum
public enum PowerUnit {

    @XmlEnumValue("MWh")
    M_WH("MWh"),
    @XmlEnumValue("mWh")
    MWH2("mWh");
    private final String value;

    PowerUnit(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static PowerUnit fromValue(String v) {
        for (PowerUnit c: PowerUnit.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}