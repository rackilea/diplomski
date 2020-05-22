public class InternetConnectionException extends RuntimeException {

    int code = 0;

    public InternetConnectionException(){
        super(AppAplication.STRING_CONSTANT.getAppName());
    }

    public InternetConnectionException(String message){
        super(message);
    }
}