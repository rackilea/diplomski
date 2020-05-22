@ControllerAdvice
class AccessDeniedExceptionHandler {

    @ExceptionHandler(value = AccessDeniedException.class)
    public void handleConflict(HttpServletResponse response) throws IOException {
        response.sendError(403, "Your Message");
    }
}