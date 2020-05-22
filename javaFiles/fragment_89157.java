boolean doInstanceOf(Object o, Class<?> clazz)
{
    return clazz.isInstance(o);
}

boolean isInstance = doInstanceOf(new MyClass(), MyClass.class)