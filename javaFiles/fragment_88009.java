@XmlRootElement(name = "campaign")
@XmlType(name = "campaign", propOrder = {
    "name",
    "type",
    "record" })
public class Campaign {
    @XmlElement(required = true)
    protected Name name;

    @XmlElement(required = true)
    protected Type type;

    @XmlElement(required = true)
    protected List<Record> record;


    public Name getName () {return name;}
    public void setName (Name value) {this.name= value;}

    public Type getType () {return type;}
    public void setType (Type value) {this.type = value;}

    //Initialise your record list inside the getter instead of in member declaration
    public List<Record> getRecord() {
        if(this.record == null) record = new ArrayList<>();
        return this.record;
    }

    //Do not use a setter as an add method for the list
    public void setRecord(List<Record> value) {this.record = value;}

    //If you need to add record inside your list, do not use a setter, define an add method or access the list with the getter.
    public void addRecord(Record value) {this.record.add(value);}
}