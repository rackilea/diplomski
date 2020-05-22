@XmlAccessorType(XmlAccessType.FIELD) 
public class ListOfEntry {
    @XmlElement
    private List<Entry> list = new ArrayList<>();
    public List<Entry> getList(){ return list; }
}

@XmlAccessorType(XmlAccessType.FIELD) 
public class Entry {
    @XmlElement
    private String key;
    @XmlElement
    private List<Parameter> list = new ArrayList<>();
    public String getKey(){ return key; }
    public void setKey( String value ){ key = value; }
    public List<Parameter> getList(){ return list; }
}