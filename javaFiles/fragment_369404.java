@ResponseStatus(value=HttpStatus.NOT_FOUND, reason="Record not found") //
public class RecordNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 8857378116992711720L;

    public RecordNotFoundException() {
        super();
    }

    public RecordNotFoundException(String message) {
        super(message);
    }
}