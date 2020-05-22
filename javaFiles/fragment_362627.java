// The T must extend SomeObject wherever it appears. This method returns a T, you call it specifying a class T. i.e. X returnObject(Class<X>. SomeClass data is a normal param
public static <T extends SomeObject> T returnObject(Class<T> classOfT, SomeClass data) throws SomeException
{
    // Create a new reference to an object of the generic type initialized to null
    T object= null; 
    // Create arrays holding the class and the data passed in as SomeClass data
    Class[] signature = new Class[] {SomeClass.class};
    Object[] args = new Object[] {data};
    // Use reflection on the Class of T to find a constructor that matches data
    Constructor<T> objectConstructor = classOfT.getDeclaredConstructor(signature);
    // Call that constructor passing in the value given
    object= (T)objectConstructor.newInstance(args);
}