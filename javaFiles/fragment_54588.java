@ExceptionHandler(MessagingException.class)
@ResponseStatus(HTTPStatus.BAD_REQUEST)
@ResponseBody
public ErrorView handleMessagingException(MessagingException ex) {
    // do something with exception and return view
}