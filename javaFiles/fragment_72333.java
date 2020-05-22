@ExceptionHandler(MissingServletRequestParameterException.class)
public void handleMissingParams(MissingServletRequestParameterException ex) {
    String name = ex.getParameterName();
    System.out.println(name + " parameter is missing");
    // Actual exception handling
}