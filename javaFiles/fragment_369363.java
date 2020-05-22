@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name = "FIELD")
public class TestLayoutNode
{

    @XmlAttribute(name = "num")
    private Integer number;

    @XmlAttribute
    private String str;

    public int getNumber() {
        if(null == number) {
           return 0;
        } else {
           return number;
        }
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getStr() {
        if(null == str) {
            return "default";
        } else {
            return str;
        }
    }

    public void setStr(String str) {
        this.str = str;
    }
}