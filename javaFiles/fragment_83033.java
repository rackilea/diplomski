/**
 * This resolver handles command objects annotated with @SupportsAnnotationParameterResolution
 * that are passed as parameters to controller methods.
 * 
 * It parses @CommandPerameter annotations on command objects to
 * populate the Binder with the appropriate values (that is, the filed names
 * corresponding to the GET parameters)
 * 
 * In order to achieve this, small pieces of code are copied from spring-mvc
 * classes (indicated in-place). The alternative to the copied lines would be to
 * have a decorator around the Binder, but that would be more tedious, and still
 * some methods would need to be copied.
 * 
 * @author bozho
 * 
 */
public class AnnotationServletModelAttributeResolver extends ServletModelAttributeMethodProcessor {

    /**
     * A map caching annotation definitions of command objects (@CommandParameter-to-fieldname mappings)
     */
    private ConcurrentMap<Class<?>, Map<String, String>> definitionsCache = Maps.newConcurrentMap();

    public AnnotationServletModelAttributeResolver(boolean annotationNotRequired) {
        super(annotationNotRequired);
    }

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        if (parameter.getParameterType().isAnnotationPresent(SupportsAnnotationParameterResolution.class)) {
            return true;
        }
        return false;
    }

    @Override
    protected void bindRequestParameters(WebDataBinder binder, NativeWebRequest request) {
        ServletRequest servletRequest = request.getNativeRequest(ServletRequest.class);
        ServletRequestDataBinder servletBinder = (ServletRequestDataBinder) binder;
        bind(servletRequest, servletBinder);
    }

    @SuppressWarnings("unchecked")
    public void bind(ServletRequest request, ServletRequestDataBinder binder) {
        Map<String, ?> propertyValues = parsePropertyValues(request, binder);
        MutablePropertyValues mpvs = new MutablePropertyValues(propertyValues);
        MultipartRequest multipartRequest = WebUtils.getNativeRequest(request, MultipartRequest.class);
        if (multipartRequest != null) {
            bindMultipart(multipartRequest.getMultiFileMap(), mpvs);
        }

        // two lines copied from ExtendedServletRequestDataBinder
        String attr = HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE;
        mpvs.addPropertyValues((Map<String, String>) request.getAttribute(attr));
        binder.bind(mpvs);
    }

    private Map<String, ?> parsePropertyValues(ServletRequest request, ServletRequestDataBinder binder) {

        // similar to WebUtils.getParametersStartingWith(..) (prefixes not supported)
        Map<String, Object> params = Maps.newTreeMap();
        Assert.notNull(request, "Request must not be null");
        Enumeration<?> paramNames = request.getParameterNames();
        Map<String, String> parameterMappings = getParameterMappings(binder);
        while (paramNames != null && paramNames.hasMoreElements()) {
            String paramName = (String) paramNames.nextElement();
            String[] values = request.getParameterValues(paramName);

            String fieldName = parameterMappings.get(paramName);
            // no annotation exists, use the default - the param name=field name
            if (fieldName == null) {
                fieldName = paramName;
            }

            if (values == null || values.length == 0) {
                // Do nothing, no values found at all.
            } else if (values.length > 1) {
                params.put(fieldName, values);
            } else {
                params.put(fieldName, values[0]);
            }
        }

        return params;
    }

    /**
     * Gets a mapping between request parameter names and field names.
     * If no annotation is specified, no entry is added
     * @return
     */
    private Map<String, String> getParameterMappings(ServletRequestDataBinder binder) {
        Class<?> targetClass = binder.getTarget().getClass();
        Map<String, String> map = definitionsCache.get(targetClass);
        if (map == null) {
            Field[] fields = targetClass.getDeclaredFields();
            map = Maps.newHashMapWithExpectedSize(fields.length);
            for (Field field : fields) {
                CommandParameter annotation = field.getAnnotation(CommandParameter.class);
                if (annotation != null && !annotation.value().isEmpty()) {
                    map.put(annotation.value(), field.getName());
                }
            }
            definitionsCache.putIfAbsent(targetClass, map);
            return map;
        } else {
            return map;
        }
    }

    /**
     * Copied from WebDataBinder.
     * 
     * @param multipartFiles
     * @param mpvs
     */
    protected void bindMultipart(Map<String, List<MultipartFile>> multipartFiles, MutablePropertyValues mpvs) {
        for (Map.Entry<String, List<MultipartFile>> entry : multipartFiles.entrySet()) {
            String key = entry.getKey();
            List<MultipartFile> values = entry.getValue();
            if (values.size() == 1) {
                MultipartFile value = values.get(0);
                if (!value.isEmpty()) {
                    mpvs.add(key, value);
                }
            } else {
                mpvs.add(key, values);
            }
        }
    }
}