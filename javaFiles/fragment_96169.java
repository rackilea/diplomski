public PolymorphicFoobar(Class<? extends Foobar> cls) {
    try {
        Method sayHi = cls.getMethod("sayHi");
        sayHi.invoke(cls);
    } catch (Exception e) {
        e.printStackTrace();
    }
}