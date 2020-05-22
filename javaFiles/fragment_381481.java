public class RequestToModelBindingArgumentResolver implements HandlerMethodArgumentResolver, Ordered {

    @Override
    public boolean supportsParameter(final MethodParameter parameter) {
        return  parameter.hasParameterAnnotation(ModelAttribute.class) &&
                parameter.getParameterType() == ModelMap.class;
    }

    @Override
    public Object resolveArgument(final MethodParameter parameter, final ModelAndViewContainer mavContainer, final NativeWebRequest webRequest, final WebDataBinderFactory binderFactory) throws Exception {

        ModelMap model = mavContainer.getModel();
        Map<String, String[]> requestParameters = webRequest.getParameterMap();

        // Bind all request parameters to the model
        for (String param : requestParameters.keySet()) {
            String[] values = requestParameters.get(param);
            if (values.length == 1) {
                model.addAttribute(param, values[0]);
            } else {
                model.addAttribute(param, values);
            }
        }

        return model;
    }

    @Override
    public int getOrder() {
        return HIGHEST_PRECEDENCE;
    }
}