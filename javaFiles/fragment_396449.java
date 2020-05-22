public class BeanObjectParameterResolver implements HandlerMethodArgumentResolver {

    @Inject
    ObjectMapper mapper;

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer,
            NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {

        Map<String, Object> params = new HashMap<>();
        Iterator<String> enumName = webRequest.getParameterNames();
        while(enumName.hasNext()){
            String name  = enumName.next();
            params.put(name, webRequest.getParameter(name));
        }

        // jackson 1.9 and before
        // mapper.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        // or jackson 2.0
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        Object obj = mapper.convertValue(params, parameter.getParameterType());

        return obj;
    }

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return !BeanUtils.isSimpleProperty(parameter.getParameterType());
    }

}