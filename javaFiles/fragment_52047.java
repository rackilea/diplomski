// File A1.java
class A1 {
    static final String s = "string"; // constant
    static String s2 = "string2"; // not constant
    static final int i = 5;  // constant
}

// File A2.java
class A2 {
    public static void main(String args[]) {
        System.out.println("A1.s: " + A1.s);
        System.out.println("A1.s2: " + A1.s2);
        System.out.println("A1.i: " + A1.i );
    }
}