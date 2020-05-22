public class StateMachine {

    // This is the missing part
    private static State state;

    public static State getState() {
       return state;
    }

    public static void setState(State newState) {
        state = newState;
    }
}