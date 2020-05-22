@Entity
public class X{
  @PostPersist
  public void myMethod(){
    //Do anything before the commit of the transaction that save a new entity of type X 
  }

 @PostUpdate
 public void myMethod2(){
  //This code will run each time you update and save an entity of type X
 }
}