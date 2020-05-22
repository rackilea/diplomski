public class Result {

    private boolean errorOccurs;
    private boolean isValid;
    private Exception exception;

    public Result(boolean isValid){
        this(isValid, false, null);
    }

    public Result(boolean isValid, boolean errorOccurs, Exception exception){
        this.isValid = isValid;
        this.errorOccurs = errorOccurs;
        this.exception = exception;
    }

    public boolean isValid(){
        return isValid;
    }

    public boolean errorOccurs(){
        return errorOccurs;
    }

    public Exception getException(){
        return exception;
    }
}