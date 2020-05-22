package mypack;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

import org.eclipse.persistence.oxm.annotations.XmlPath;

@XmlRootElement(name = "Employee")
public class Employee {

    private String name;
    private String address;
    private int empId;
    private String addressType;

    @XmlAttribute
    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @XmlPath("address/@type")
    public String getType() {
        return addressType;
    }

    public void setType(String addressType) {
        this.addressType = addressType;
    }
}