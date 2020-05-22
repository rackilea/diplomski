package example;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="report",namespace="urn:report")
public class Root {

    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}