package com.mycompany.sandbox;

import java.lang.reflect.InvocationTargetException;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;


abstract class AbstractSuperClass{

    public abstract void someAbstractMethod();


    public static String getSomeText(){ 
        return "This is AbstractSuperClass"; 
    };

    public static Class<? extends AbstractSuperClass> getConcreteClass(int x){
        switch( x ){
            case 0: return ConcreteClassA.class;
            case 1: return ConcreteClassB.class;
        }
      return null;
    }
}


class ConcreteClassA extends AbstractSuperClass{
    public void someAbstractMethod(){
        // Do something
    }

    public static String getSomeText(){ 
        return "This is ConcreteClassA"; 
    };
}



class ConcreteClassB extends AbstractSuperClass{
    public void someAbstractMethod(){
        // Do something
    }

    public static String getSomeText(){ 
        return "This is ConcreteClassB"; 
    };
}




// one class needs to have a main() method
public class HelloWorld
{
  // arguments are passed using the text field below this editor
  public static void main(String args[])
  {
      try {
          final Class<? extends AbstractSuperClass> clazz = AbstractSuperClass.getConcreteClass(1);
          Object result = clazz.getMethod("getSomeText").invoke(clazz);
          System.out.println(Objects.toString(result, "<NULL>"));
      } catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
          Logger.getLogger(HelloWorld.class.getName()).log(Level.SEVERE, null, ex);
      }
  }
}