@ExceptionHandler(ServiceExecutionException.class)
@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
@ResponseBody
public ResponseEntity<ErrorInfo> handleServiceError(ServiceExecutionException ex,
            HandlerMethod handlerMethod, WebRequest webRequest) {
   String url = ((ServletWebRequest)webRequest).getRequest().getRequestURL().toString();
   ErrorInfo errorInfo = new ErrorInfo(url, ex.getLocalizedMessage());
   return new ResponseEntity<ErrorInfo>(errorInfo, HttpStatus.INTERNAL_SERVER_ERROR);
}