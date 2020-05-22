Class<?> cl2 = ... ;        

    // If the class has a no-arg visible constructor
    Object foo = cl2.newInstance();

    // Or using an explicit constructor (here with an integer and a String as arguments)
    Constructor<Class<?>> cons = cl2.getConstructor(Integer.class, String.class);
    Object bar = cons.newInstance(1, "baz");