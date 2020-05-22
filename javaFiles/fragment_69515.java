public class BeanWithId implements Serializable {
  private String id;
  private String info;

  private void populateInfo() {
    info = "Some info from data source for id=" + id;
  }

  public String getId() { return id; }

  public void setId(String id) {
    this.id = id;
    populateInfo();
  }

  public String getInfo() { return info; }
  public void setInfo(String info) { this.info = info; }

  public String save() {
    System.out.println("Saving changes to persistence store");
    return null; // no navigation
  }
}