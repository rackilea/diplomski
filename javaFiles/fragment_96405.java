public interface MyInterface<T> {    
      public T getInstance();
}

public class Class1 implements MyInterface<Class1> {
      public Class1 getInstance() {
         return this;
      }
}

public class Class2 implements MyInterface<Class2> {  
     public Class2 getInstance() {
        return this;
     }
}