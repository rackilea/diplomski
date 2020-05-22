String template = "..."; // some package definition
for (Property<?> crt : bag)
{
    String className = template + crt.getClassName();
    Class<? extends PropertyWrapper<?>> wrapperClass = null;
    wrapperClass = (Class<? extends PropertyWrapper<?>>) Class.forName(className);
    Constructor<? extends PropertyWrapper<?>> constructor = wrapperClass.getConstructor(new Class<?>[] {Property.class});
    PropertyWrapper<?> wrapper = constructor.newInstance(crt);
    // Further operations using the wrapper
}