public class A {

    @Parameter(names = "-argname1")
    static boolean x;
    @Parameter(names = "-argname2", variableArity = true)
    static List<String> y;

    @Parameter
    public static List<String> remainingParameters;

    void main(String[] args) {
        new JCommander(A.class.newInstance(), args);
        System.out.println("got argname1 = " + x);
        System.out.println("got argname2 = " + y);
    }
}