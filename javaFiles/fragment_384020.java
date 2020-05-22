public class UrlClassloaderTest {
    public static void main(String[] args) throws Exception {
        URL jarUrl = UrlClassloaderTest.class.getResource("hello.jar");
        URLClassLoader cl = new URLClassLoader(new URL[] { jarUrl }, UrlClassloaderTest.class.getClassLoader());

        Class helloClass = cl.loadClass("test.Hello");
        Constructor constructor = helloClass.getConstructor(String.class);
        Object helloObject = constructor.newInstance("some configuration");
        Method messageMethod = helloClass.getMethod("getMessage");
        String message = (String) messageMethod.invoke(helloObject);

        System.out.println(message);
    }
}