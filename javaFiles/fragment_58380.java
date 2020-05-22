@ControllerAdvice
public class MyExceptionHandler {

    private final MyService service;

    @Autowired
    public MyExceptionHandler(MyService service) {
        this.service = service;
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.CONTINUE) // I don't figure out how to abort request
    public ResponseEntity<Void> handle(Exception ex) {
        try {
            service.getEmitter().send(SseEmitter.event().data(ex.getMessage()));
        } catch (IOException e) {
            // TODO
        }
    }
}