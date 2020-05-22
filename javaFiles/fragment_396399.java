import javax.xml.bind.annotation.*;

@XmlRootElement(name = "root")
@XmlAccessorType(XmlAccessType.FIELD)
public class abc {

    private String[] emp = new String[2];
    private String xyz;

    public String getEmp1() {
        return emp[0];
    }

    public void setEmp1(String emp1) {
        this.emp[0] = emp1;
    }

    public String getEmp2() {
        return emp[1];
    }

    public void setEmp2(String emp2) {
        this.emp[1] = emp2;
    }

    public String getXyz() {
        return xyz;
    }

    public void setXyz(String xyz) {
        this.xyz = xyz;
    }

}