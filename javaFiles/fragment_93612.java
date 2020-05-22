@Override
public void handleReturnValue(Object returnValue, MethodParameter returnType,
        ModelAndViewContainer mavContainer, NativeWebRequest webRequest)
        throws IOException, HttpMediaTypeNotAcceptableException {

    mavContainer.setRequestHandled(true);
    if (returnValue != null) {
        writeWithMessageConverters(returnValue, returnType, webRequest);
    }
}