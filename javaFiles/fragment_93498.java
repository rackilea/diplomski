public class Operation {

    private final static Operation PLUS = new Operation("PLUS");
    private final static Operation MINUS = new Operation("MINUS");

    static {
        System.out.println("In static initialiser");
        System.out.print("PLUS = " + PLUS);
        System.out.println("\tMINUS = " + MINUS);
    }

    public Operation(String s) {
        System.out.println("In constructor: " + s);
        System.out.print("PLUS = " + PLUS);
        System.out.println("\tMINUS = " + MINUS);
    }

    public static void main(String[] args) {
        Operation afterStatic = new Operation ("after static");
    }    
}