@RequestMapping(..)
public String submit(..) {
    if (hidden field is empty) {
        throw new IllegalStateException("Missing XXX");
    }
    ....
   return "redirect:success"
}

@ExceptionHandler
public String handle(IllegalStateException e) {
    logger.warn("User attempted to fiddle with POST data");
    return "error";
}