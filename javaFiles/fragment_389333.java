@ControllerAdvice
public class ExcptionController {
    private static final List<String> EXPOSABLE_FIELDS = asList("timestamp", "status", "error", "message", "path");

    @Autowired private ErrorAttributes errorAttributes;

    @ExceptionHandler(UnsatisfiedServletRequestParameterException.class)
    private ResponseEntity foo(HttpServletRequest request) {
        Map<String, Object> errors = getErrorAttributes(request);
        errors.put("message", "Invalid parameter");

        return ResponseEntity.badRequest().body(errors);
    }

    private Map<String, Object> getErrorAttributes(HttpServletRequest request) {
        ServletRequestAttributes requestAttributes = new ServletRequestAttributes(request);
        final boolean WITHOUT_STACK_TRACE = false;
        Map<String, Object> attributes = errorAttributes.getErrorAttributes(requestAttributes, WITHOUT_STACK_TRACE);

        // log exception before removing it
        attributes.keySet().removeIf(key -> !EXPOSABLE_FIELDS.contains(key));

        return attributes;
    }
}