package jaxb_element_test;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "container")
@XmlAccessorType(XmlAccessType.FIELD)
public class Container {
    @XmlElement(name = "name")
    private String name;

    @XmlElement(name = "number")
    private int number;

    @XmlElements({
            @XmlElement(name="stringSubclass", type=StringSubclass.class),
            @XmlElement(name="intSubclass", type=IntSubclass.class)})
    private List<ParentClass> list;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public List<ParentClass> getList() {
        return list;
    }

    public void setList(List<ParentClass> list) {
        this.list = list;
    }
}