public class Worker {

    private Caller caller;

    public Worker(Caller caller) {
        this.caller = caller;
    }

    public int workForMe() {
        // now the conditions:
        if(clearBlueSky) {
            // this emulates a "return"
            caller.setState(true);
        }
        // this returns from the method
        return 1;
    }

}