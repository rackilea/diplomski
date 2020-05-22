class CustomException extends Exception {}       

@Override
public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) {
    Object output = null;

    try {
        output = actualMethod();
    }
    catch (CustomException e) {
        // do your JSON error handling here     
    }

    return output;
}

private Object actualMethod() throws CustomException {
    if (somethingBadHappened) throw new CustomException();
    else return new Object();
}