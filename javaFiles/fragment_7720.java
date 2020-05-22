public class FinalExample {
    private final String a = "Hello World!"; // cannot be reassigned
    private String b = "Goodbye World!"; // can be reassigned

    public FinalExample() {
        a = b; // ILLEGAL: this field cannot be re-assigned
        b = a; 
    }

    public static void main(String[] args) {
        new FinalExample();
    }
}