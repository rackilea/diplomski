public final class MyTest {
    private final List<TypeX> listOfTypeX = null;
    private final Type typeOfListOfTypeX = MyTest.class
        .getDeclaredField("listOfTypeX")
        .getGenericType();
}