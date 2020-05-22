public abstract BaseClass<T>{
protected Class<? extends T> clazz;

    public BaseClass(Class<? extends T> theClass)
    {
        this.clazz = theClass;
    }
...
}