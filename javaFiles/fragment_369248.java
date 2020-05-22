public static Object createObject(Constructor constructor,
      Object[] arguments) {

    System.out.println("Constructor: " + constructor.toString());
    Object object = null;

    try {
      object = constructor.newInstance(arguments);
      System.out.println("Object: " + object.toString());
      return object;
    } catch (InstantiationException e) {
      //handle it
    } catch (IllegalAccessException e) {
      //handle it
    } catch (IllegalArgumentException e) {
      //handle it
    } catch (InvocationTargetException e) {
      //handle it
    }
    return object;
  }
}