package com.example;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "")
@XmlEnum
public enum MyEnumType {

    MY_ENUM_1,
    MY_ENUM_2;

    public String value() {
        return name();
    }

    public static MyEnumType fromValue(String v) {
        return valueOf(v);
    }

}