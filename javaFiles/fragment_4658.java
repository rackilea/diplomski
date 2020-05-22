public abstract class DataObject {

  private String value;
  private String dataType;

  public String getValue() {
    return value;
  }
  public void setValue(String value) {
    this.value = value;
  }
  public String getDataType() {
    return dataType;
  }
  public void setDataType(String dataType) {
    this.dataType = dataType;
  }

  public abstract String getMatch();
  public abstract void setMatch(String match);
}