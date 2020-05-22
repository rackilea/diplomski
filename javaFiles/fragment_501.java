import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlValue;

@XmlAccessorType(XmlAccessType.NONE)
public class ErrorCodesDto {

    @XmlValue
    private String ERROR_CODE;

    public ErrorCodesDto() {
    }

}