@XmlRootElement(name = "Generic_Name")
public class GenericName {

    @XmlElement(name = "Name")
    protected List<Name> name;

    public List<Name> getNames() {
        if (name == null) {
            name = new ArrayList<Name>();
        }
        return this.name;
    }
}