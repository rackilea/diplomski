class D<T_I extends I> implements InvocationHandler, I {

  public static <T_I extends I> T_I decorate(T_I wrappedValue) {
    return (T_I)Proxy.newProxyInstance(
        wrappedValue.getClass().getClassLoader(),
        getAllInterfaces(wrappedValue.getClass()),
        new D<T_I>(wrappedValue));
  }

  private static Class[] getAllInterfaces(Class type) {
    if (type.isInterface()) {
      Class[] all = new Class[type.getInterfaces().length + 1];
      int i = 0;
      all[i++] = type;
      for (Class t : type.getInterfaces()) {
        all[i++] = t;
      }
      return all;
    } else {
      return type.getInterfaces();
    }
  }


  private final T_I wrappedValue;

  private D(T_I wrappedValue) {
    this.wrappedValue = wrappedValue;
  }

  public Object invoke(Object proxy, Method method, Object[] args) {
    if (method.getDeclaringClass() == I.class) {
      // call wrapped method in D
      return method.invoke(this, args);
    }
    //call unwrapped method of other interface
    return methos.invoke(wrappedValue, args);
  }

  // Methods for I
}