package one;

public class MainClass {

    private static String[] argsCopy;

    public static void main(String[] args) {
        argsCopy = args;
    }

    public static String[] getArgs() {
        return argsCopy;
    }
}

package one.onePointOne;

public class TheOtherClass {

    public void someMethod() {
         String iWantTheValueOfArgsHere = one.MainClass.getArgs()[argNumber];
    }
}