static <T> void doSomething(final Class<T> type, final T instance) 
{
}

//here the unchecked cast warning can be suppressed. 
//It could be somewhere else though, the unchecked cast I mean. This is one solution only.
@SuppressWarnings("unchecked")
static <T> Class<T> getType(final T instance) 
{
    return (Class<T>) instance.getClass();
}

static <T> void doSomething(final T instance) 
{
    final Class<T> type= getType(instance);
    //call to doSomething with a type and an instance
    doSomething(type, instance);
}