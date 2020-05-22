public abstract class Foo implements OtherThing {//....}  

public class Bar extends Foo{  
  public static Map<Enum, List<AnotherEnum> getSomeThingMap(){  
    create someThingMap; 

    //Call your static Method from Foo here
    Foo.staticMethod()
    someThingMap.put(Enum, List<AnotherEnum>);
    return someThingMap;  
  }  
}