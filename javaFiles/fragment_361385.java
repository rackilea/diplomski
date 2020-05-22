protected ResponseEntity<ResponseJson> buildResponse(
    final ResponseJson jsonResponseBody,
    final HttpStatus httpStatus)
{
    final ResponseEntity<ResponseJson> returnValue;

    if ((jsonResponseBody != null) &&
        (httpStatus != null))
    {
        returnValue = new ResponseEntity<>(
            jsonResponseBody,
            httpStatus);
    }

    return returnValue;
}