package forum11001458;

import javax.xml.bind.annotation.*;

@XmlRootElement(name="MyResult")
public class MyResult {

    @XmlElement(name="AccountID")
    private String accountID;

    @XmlElement(name="User")
    private User user;

    @XmlElement(name="Result")
    private Result result;

}