public class ModelAttributeMethodProcessor {

protected Object createAttribute(String attributeName, MethodParameter parameter,
            WebDataBinderFactory binderFactory, NativeWebRequest webRequest) throws Exception {

        MethodParameter nestedParameter = parameter.nestedIfOptional();
        Class<?> clazz = nestedParameter.getNestedParameterType();

        Constructor<?> ctor = BeanUtils.findPrimaryConstructor(clazz);
        if (ctor == null) {
            Constructor<?>[] ctors = clazz.getConstructors();
            if (ctors.length == 1) {
                ctor = ctors[0];
            }
            else {
                try {
                    ctor = clazz.getDeclaredConstructor(); // FAILS HERE
                }
                catch (NoSuchMethodException ex) {
                    throw new IllegalStateException("No primary or default constructor found for " + clazz, ex);
                }
            }
        }
......................................
......................................