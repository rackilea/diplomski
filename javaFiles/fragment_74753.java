import groovy.lang.Binding;
import groovy.lang.GroovyShell;
import groovy.util.Eval;

public class Goovy123 {
    public static void main(String[] args) throws InterruptedException {
        Binding binding = new Binding();
        String foo="foo";   
        binding.setVariable("foo", foo);
        GroovyShell shell = new GroovyShell(binding);
        System.out.println("Original state: "+binding.getVariable("foo"));
        shell.evaluate("foo=foo.toUpperCase();");
        System.out.println("Changed state: "+binding.getVariable("foo"));
    }
}