package mypack;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlValue;

public class Address {

    private String address;
    private String addressType;

    @XmlValue   
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @XmlAttribute
    public String getType() {
        return addressType;
    }

    public void setType(String addressType) {
        this.addressType = addressType;
    }
}