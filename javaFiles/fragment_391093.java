class OtherException extends Exception {
    OtherException(Exception ex, String exStr) {}
}

class MyException extends Exception {

    Exception ep;

    public MyException() {
        super();
        // ep = new Exception();
    }

    public OtherException getILException(long txnId) {
            // the error is here, according to the stacktrace
        return new OtherException(ep, ep.toString());
    }
}

public class Test {
    public static void main(String args[]) throws OtherException {
        try{
            throw new MyException();
        }catch (MyException e){
            throw e.getILException(100);
        }
    }
}