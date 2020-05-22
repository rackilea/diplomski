try {
    Class<?> myClass = Class.forName("Foo");
    Method myMethod = myClass.getMethod("bar");
    Object retObject = myMethod.invoke(null);
} catch (Exception e) {
    // handle errors here...
    e.printStackTrace();
}