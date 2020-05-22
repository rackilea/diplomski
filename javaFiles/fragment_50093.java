@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
   "row"
})
@XmlRootElement(name = "root")
public class Root {

  @XmlElement(required = false)
  protected List<Row> row;

  public List<Row> getRow() {
    if (row == null) {
        row = new ArrayList<Row>();
    }
    return this.row;
  }

  @XmlAccessorType(XmlAccessType.FIELD)
  @XmlType(name = "", propOrder = {
    "millis",
    "stamp",
    "datetime",
    "light",
    "temp",
    "vcc"
  })
  public static class Row {
    protected Integer millis;
    protected String stamp;
    protected String datetime;
    protected Integer light;
    protected double temp;
    protected double vcc;

    public Integer getMillis() {
        return millis;
    }
    public void setMillis(Integer value) {
        this.millis = value;
    }
    public String getStamp() {
        return stamp;
    }
    public void setStamp(String value) {
        this.stamp = value;
    }
    //-...continue with the other getters and setters

  }
}