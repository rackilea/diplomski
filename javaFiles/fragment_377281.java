@ExceptionHandler(value = MethodArgumentNotValidException.class)
public void exceptionHandler(final MethodArgumentNotValidException ex, 
                     final HttpServletResponse response) throws IOException {

    for (final ObjectError objectError : ex.getBindingResult().getAllErrors()) {
        response.getWriter().append(objectError.getDefaultMessage()).append(".");
    }
    response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
}