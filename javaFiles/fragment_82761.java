public class Caller {
    public void aMethod() {
        Callee calleeObj = new Callee();
        new Thread(calleeObj::aSpecificMethod).start();
    }
}