public interface SomeInterface<X>{
    void methodOfT(X object);
}
public class X<T1, T2 extends SomeInterface<T1>>
{
     T1 obj1;
     T2 obj2;
     public void methodOfX()
     {
          obj2.methodOfT(obj1);
     }  
}