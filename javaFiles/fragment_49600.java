public class FooResolver implements HandlerMethodArgumentResolver {

public static final String ID = "id";
public static final String DESCRIPTION = "description";

@Override
public boolean supportsParameter(MethodParameter parameter) {
    return parameter.getParameterType().equals(Foo.class);
}

@Override
public Object resolveArgument(MethodParameter parameter,
                              ModelAndViewContainer mavContainer, 
                              NativeWebRequest webRequest,
                              WebDataBinderFactory binderFactory) throws Exception {

    Foo foo = null;

    if(parameter.getParameterType().equals(Foo.class)) {

        foo = new Foo();

        if (webRequest.getParameter(ID) != null) tag.setId((String) webRequest.getParameter(ID));
        if (webRequest.getParameter(DESCRIPTION) != null) tag.setDescription((String) webRequest.getParameter(DESCRIPTION));
    }

    return foo;
}