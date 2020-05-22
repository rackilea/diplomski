public class MyFactory {
  public static MyObject newObject(SomeComponent someComponent /* and other parameter if needed */) {
    ... // in this scope(A), many classes are used to generate MyObject;
   return MyObject;  
  } 
}