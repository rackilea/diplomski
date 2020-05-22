@XmlRootElement  
@XmlAccessorType(XmlAccessType.FIELD)  // <======= This Here
public class Account {
    // added toString for testing
    @Override
    public String toString() {
        return "Account{" + "name=" + name 
                          + ", type=" + type 
                          + ", id=" + id + '}';
    }
}