package forum9988170;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="data")
public class DataBean {

    private String field2;
    private String field5;

    public String getField2() {
        return field2;
    }

    public void setField2(String field2) {
        this.field2 = field2;
    }

    public String getField5() {
        return field5;
    }

    public void setField5(String field5) {
        this.field5 = field5;
    }

}