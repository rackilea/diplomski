interface MyIntf
    {
       void runMyMethod()
    }

    public class ObjectX implements MyIntf {
           void runMyMethod()
           {
           }
    }

    public class ObjectB { 

      public MyIntf parentX;

      public ObjectB(MyIntf x) {
        parentX = x;
      } 

      public void anyMethod() { 
        parentX.runMyMethod(); 
      } 
    }