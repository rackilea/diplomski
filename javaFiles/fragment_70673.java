import groovy.lang.GroovyShell;

public class SomeClass {

    public static void main(String[] args) {
        GroovyShell shell = new GroovyShell();

        for (String arg : args) {
            Object result = shell.evaluate(arg);

            System.out.println("result is: "+result);
        }
    }

}