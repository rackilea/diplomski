public class Main {
    interface Foo { }
    class A {
        List<Foo> myList = new ArrayList<Foo>();
    }
    public static void main(String... args) throws NoSuchFieldException {
        ParameterizedType myListType = ((ParameterizedType) 
                                A.class.getDeclaredField("myList").getGenericType());
        System.out.println(myListType.getActualTypeArguments()[0]);
    }
}