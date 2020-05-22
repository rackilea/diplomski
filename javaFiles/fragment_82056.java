public class Main {
    public static void main(String[] args) throws ClassNotFoundException {
        ClassLoader cl = new URLClassLoader(new URL[0], ClassLoader.getSystemClassLoader());
        System.out.println("unresolved Test");
        cl.loadClass("Test");
        // or
        Class.forName("Test", false, cl);

        System.out.println("\ninitialise Test");
        Class.forName("Test", true, cl);
    }
}

class Test {
    static {
        System.out.println("Loaded Test class");
    }
}