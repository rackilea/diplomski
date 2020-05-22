@ExceptionHandler(EntityNotFoundException.class)
  public final Object handleEntityNotFoundException(EntityNotFoundException enfe, HandlerMethod handlerMethod) {

    boolean isRestController = handlerMethod.hasMethodAnnotation(ResponseBody.class)
        || handlerMethod.getBeanType().isAnnotationPresent(ResponseBody.class)
        || handlerMethod.getBeanType().isAnnotationPresent(RestController.class);

    if (isRestController) {
      return new ResponseEntity<>(enfe.getMessage(), HttpStatus.NOT_FOUND);
    } else {
      Map<String, Object> model = ImmutableMap.of("message", enfe.getMessage());
      return new ModelAndView("error", model, HttpStatus.NOT_FOUND);
    }
  }