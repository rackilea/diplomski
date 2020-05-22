@Entity
public class ModelClass implements Serializable {    
  /*..... some Code .... */

  @Column(name="activeYN")
  private short active; 

  public boolean isActive() {
    return this.active!=0; 
  }
 /* .... some other Code ... */

}