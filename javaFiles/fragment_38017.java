public class Response<T> {
    String result;
    String message;
    T customField;

    public Response(String result, String message, T customField) {
        this.result = result;
        this.message = message;
        this.customField = customField;
    }
    //getter setter
}