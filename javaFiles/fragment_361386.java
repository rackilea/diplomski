public ResponseEntity<ResponseJson> handlerMethod(
    ... params)
{
    ... stuff

    return buildResponse(json, httpStatus);
}