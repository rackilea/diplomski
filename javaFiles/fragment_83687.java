public class Debug {
    public final static boolean DEBUG = true; // or false
}

public class X {
    public m() {
        if (Debug.DEBUG) {
             // Do some timing or displaying mouse positions, or whatever.
        }
    }
}