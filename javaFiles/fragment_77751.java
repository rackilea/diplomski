@IdClass( DMKeyClass.class )
@Entity
class DataModel {
  @Id
  private Satellite sat;
  @Id
  private int orbit;
  private int data;
}

class DMKeyClass {
  public int sat;
  public int orbit;
}