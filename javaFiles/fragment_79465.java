abstract class MyGeneric<T> {

    private T instance;

    public MyGeneric(String str) {
        // grab the actual class represented by 'T'
        // this only works for subclasses of MyGeneric<T>, not for MyGeneric itself !
        Class<T> genericType = (Class<T>) ((ParameterizedType)getClass().getGenericSuperclass())
                .getActualTypeArguments()[0];
        try {
            // instantiate that class with the provided parameter
            instance = genericType.getConstructor(String.class).newInstance(str);
        } catch (Exception e) {
            throw new IllegalArgumentException(e);
        }
    }
}

class MyUser extends MyGeneric<User> {
    public MyUser() {
        // provide the string to use for instantiating users...
        super("userStr");
    }
}

class User { /*...*/ }