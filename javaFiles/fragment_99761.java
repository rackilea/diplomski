class ExceptionResponse {
    private CustomException exception;
}
class CustomException {
    private Date timestamp;
    private Message message; //can even split message further.
    private String details;
}

class Message {
    private int id;
    private String category;
    private String comment;
}