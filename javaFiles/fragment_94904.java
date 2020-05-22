public class Test {

    public static final int INITIAL_STATE = 6;
    private static int myVar = INITIAL_STATE;



    public static boolean getVar(int index) {
        return (myVar & (1 << index)) != 0;
    }



    public static void setVar(int index, boolean value) {
        if (value) {
            myVar |= (1 << index);
        } else {
            myVar &= ~(1 << index);
        }
    }



    public static void printState() {
        System.out.println("Decimal: " + myVar + "  Binary: " + Integer.toBinaryString(myVar));
    }



    public static void main(String[] args) {
        System.out.println(getVar(0)); // false
        System.out.println(getVar(1)); // true
        System.out.println(getVar(2)); // true
        printState();

        setVar(0, true);
        System.out.println(getVar(0)); // now, true
        printState();
    }
}