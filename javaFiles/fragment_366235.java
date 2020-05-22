public class A {

    @Test
    public void test() {
        InputStream stream = A.class.getResourceAsStream("/SomeTextFile.txt");
        System.out.println(stream != null);
        stream = Test.class.getClassLoader()
            .getResourceAsStream("SomeTextFile.txt");
        System.out.println(stream != null);
    }

}