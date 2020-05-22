@ControllerAdvice // To Handle Exceptions
public class ExceptionController {
     //// ...........

     @ExceptionHandler({HttpUnauthorizedException.class})
     @ResponseBody
     @ResponseStatus(value = HttpStatus.UNAUTHORIZED)
     Map<String, String> unauthorizedAccess(Exception e) {
         Map<String, String> exception = new HashMap<String, String>();

         log.error("unauthorized Access to the API: " + e.getMessage(), e);
         exception.put("code", "401");
         exception.put("reason", e.getMessage());

         return exception;
     }
}