public final class Util {
    private Util() {
    }

    static void someMethod() { }

    static class DoesSomething {
         void method() {
             // WAT!? we can still create this utility class
             // when we wrote more code, but it's not as good.
             new Util().someMethod(); 
         }
    }
}