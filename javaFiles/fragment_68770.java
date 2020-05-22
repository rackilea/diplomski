public class Example {
    public static void main(String[] args) {
        int n = 3; // the name could be "number" and no behavior would change
        Object bf = binaryForm(n);
        // do something with bf
    }

    private static Object binaryform(int number) {
        // from the call above, number will have the value 3
        Object o = . . .;
        // generate or modify o from the value of number
        return o;
    }
}