@XmlRootElement(name="ROOT")
public class Dataset {

  @XmlElementWrapper(name="fieldset")
  @XmlElement(name="field")
  public List<Field> fields = new LinkedList<Field>();

  @XmlElementWrapper(name="rowset")
  @XmlElement(name="row")
  public List<Row> rows = new LinkedList<Row>();

}

public class Field {
  @XmlElement(name="Id")
  public String id;
  @XmlElement(name="Name")
  public String name;
  @XmlElement(name="DataType")
  public String dataType;
}

public class Row {
  @XmlAnyElement
  public Map<QName, String> columns = new HashMap<QName, String>();
}