public interface SomeInterface{
    void methodOfT();
}
public class X<T extends SomeInterface>
{
     T obj;
     public void methodOfX()
     {
          obj.methodOfT();
     }  
}