public abstract class Foo<T extends Foo<T>>  // see ColinD's comment
{
    public T eat(String eatCake) 
    {
        return (T)this;
    }
}

public class CakeEater extends Foo<CakeEater> 
{
    public void f(){}
}