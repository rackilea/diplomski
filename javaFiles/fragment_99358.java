public class ObjA
{
    public void MethodA(Func<MyType<MySubType>, MyOtherType, MyAnotherType> arg, int arg2)
    {
        Console.WriteLine("Called MethodA with args: Func<MyType<MySubType>, MyOtherType, MyAnotherType> arg, int arg2");
    }
    public void MethodA(Func<MyOtherType> arg, int arg2)
    {
        Console.WriteLine("Called MethodA with args: Func<MyOtherType> arg, int arg2");
    }
}