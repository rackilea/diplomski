@Controller
public class MyController {
    /*
       Method throwing MyException1
       Method throwing MyException2
       Method throwing MyException3
    */

    @ExceptionHandler(MyException1.class)
    public void handleMyException1(Exception ex){
         //MyException4 exe4 = new MyException4();
        // Add the required details to it
        throw exe4;
    }

    @ExceptionHandler(MyException2.class)
    public void handleMyException2(Exception ex){
        System.out.println("Exception Logged inside Controller")
    }
}

@ControllerAdvice
public class MyGlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    public void handleAllException(Exception ex){
        System.out.println("Exception logged Outside Controller");
    }
}