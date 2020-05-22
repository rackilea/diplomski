@Entity
public class ModelClass implements Serializable {    
  /*..... some Code .... */
  private boolean active; 


  @org.hibernate.annotations.Type(type = "my.package.ShortToBooleanUserType")
  @Column(name="activeYN")
  public boolean isActive() {
    return this.active; 
  }
 /* .... some other Code ... */

}