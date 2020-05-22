public class SingleObject {

 //create an object of SingleObject
 private static SingleObject instance = new SingleObject();

 private String name;
 private String age;

 //make the constructor private so that this class cannot be
 //instantiated
   private SingleObject(){}

 //Get the only object available
 public static SingleObject getInstance(){
  return instance;
 }

  // here u can declare getter setter


public String getName() {
    return name;
}

public void setName(String name) {
    this.name = name;
}

public String getAge() {
    return age;
}

public void setAge(String age) {
    this.age = age;
}

}