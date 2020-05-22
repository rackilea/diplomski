import groovy.util.Eval;

public class Goovy123 {
    public static void main(String[] args) {
        System.out.println(Eval.me("33*3"));//99
        System.out.println(Eval.me("'foo'.toUpperCase()"));//FOO
    }
}