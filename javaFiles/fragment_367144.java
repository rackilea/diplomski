@ManagedBean
public class OtherBean implements Serializable {

    @ManagedProperty(value="#{userManagerBean}")
    private UserManagerBean userManagerBean;

    // ...
}