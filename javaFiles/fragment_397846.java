public class GC { 

  private Object o; 
  private void setObj(Object obj) { o = obj; } 
  public void doSomething() { 
     Object o = new Object(); //4
     setObj(o); 
     o = new Object(); //6
     setObj(null); //7
     o=null; 
    }
  }