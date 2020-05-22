@ExceptionHandler
@ResponseStatus(HttpStatus.BAD_REQUEST)
@ResponseBody
public String handleException(BusinessException ex) {
    String message = messageSource.getMessage(ex.getMessage(),
            ex.getParams(), LocaleContextHolder.getLocale());
    LOGGER.debug("Inside Handle Exception:" + message);
    return message;
}