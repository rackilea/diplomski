import javax.xml.bind.annotation.XmlElement;

public class UserRow {

    @XmlElement(name="USER_ID")
    private int userID;

    @XmlElement(name="USER_NAME")
    private String userName;

}