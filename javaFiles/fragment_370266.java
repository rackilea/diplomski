public class BaseAbstractClass {
  private Connection getConnection(){
      //somecode 

  }

  public boolean save(){
      //get connection and do something 
      //return ;
  }

//your implementor is left to implement it , he  can use save method but can'ge see what it does i mean i doesn't have access to getConnection
  public abstract void saveEntity();

}