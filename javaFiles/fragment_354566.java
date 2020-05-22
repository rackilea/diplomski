@ManagedBean
public class Foo {
  @ManagedProperty(value = "#{bar}")
  private Bar bar;
  //add setters and getters for bar
  public Bar getBar(){
      return this.bar;
  }
  public void setBar(Bar bar){
      this.bar = bar;;
  }
}