public class Person(){
  private String name;
  private int id;

  public Person(String n, int id){
    this.name = n;
    this.id = id;
  }

  public String toString(){
    return "Name: " + name + ", " + id;
  }
}