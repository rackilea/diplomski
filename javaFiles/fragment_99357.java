public class ObjA
{
    public void MethodA(Func<MyType<MySubType>, MyOtherType, MyAnotherType>  arg)
    {
        Console.WriteLine("Called MethodA");
    }
}

public class MyType<T>
{

}
public class MySubType
{

}

public class MyOtherType
{

}

public class MyAnotherType
{

}