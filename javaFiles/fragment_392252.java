public class JSWrapper {

    private Object returnVal;
    private Exception exception;

    public void setRV(Object returnVal) {
        this.returnVal = returnVal;
    }

    public Object getRV() {
        return this.returnVal;
    }

    public void setException(Exception exception) {
        this.exception = exception;             
    }

    public Exception getException() {
        return this.exception;              
    }

}