public class SearchCriteriaResolver implements HandlerMethodArgumentResolver {

    @Override
    public boolean supportsParameter(MethodParameter methodParameter) {
        return methodParameter.hasParameterAnnotation(SearchCriteria.class);
    }

    @Override
    public Object resolveArgument(MethodParameter methodParameter, ModelAndViewContainer modelAndViewContainer, NativeWebRequest nativeWebRequest, WebDataBinderFactory webDataBinderFactory) throws Exception {

        // somehow determine search params

        // setup + return your new SearchParams object to encapsulate your determined search params
        SearchParams searchParams = new SearchParams();
        searchParams.add("somekey", "somevalue");
        return searchParams;
    }
}