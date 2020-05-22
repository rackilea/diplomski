@ControllerAdvice    
public class CustomControllerAdvice {

    @InitBinder
    private void activateDirectFieldAccess(DataBinder dataBinder) {
        dataBinder.initDirectFieldAccess();
    }

    ...
}