package com.mycompany.enums;

public enum ServiceProperty {

    NOT_SO_SIMPLE("secondvalue"),
    PROPERTY_WITH_CAMEL_CASE("thirdvalue"),
    SIMPLE("value");

    private ServiceProperty(String value){
        this.value = value;
    }

    private String value;

    public String getValue(){
        return this.value;
    }

}