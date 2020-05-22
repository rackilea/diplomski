@ExceptionHandler({org.springframework.http.converter.HttpMessageNotReadableException.class})
@ResponseStatus(HttpStatus.BAD_REQUEST)
@ResponseBody
public String resolveException() {
    return "error";
}