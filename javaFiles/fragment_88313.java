@Entity(noClassnameStored = true)
public class MyObjectId { 

  @Property("id1")
  private String id1; 

  @Property("id2")
  private String id2;

  public MyObjectId() {
  }

  public MyObjectId(String id1, String id2) {
    this.id1 = id1;
    this.id2 = id2;
  }

}