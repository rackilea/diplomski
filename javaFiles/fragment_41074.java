@XmlRootElement
public class App {

    @XmlAttribute  // VALID
    private boolean foo;

    private boolean bar;

    @XmlAttribute // VALID
    public boolean isBar() {
        return bar;
    }

    @XmlAttribute  // INVALID
    public boolean isOwned( User user ) {
        return user.ownsApp( getId( ) );
    }

}