void caller() 
{
    Class<MyClass> clazz = MyClass.class;
    Object obj = new MyClass();
    foo(cast(obj, clazz));
}

private <T> T cast(Object obj, Class<T> clazz)
{
    return (T) obj;
}