public final class MyAnnotationPostProcessor implements BeanPostProcessor {

    private static final Log LOG = LogFactory.getLog(MyAnnotationPostProcessor.class);

    public Object postProcessBeforeInitialization(Object bean, String beanName)
            throws BeansException {
        final Set<Field> annotatedFields = getAnnotatedFields(bean.getClass());
        for (Field annotatedField : annotatedFields) {
            LOG.info("Post process before initialization " + beanName + "," + annotatedField);
        }
        return bean;
    }

    public Object postProcessAfterInitialization(Object bean, String beanName)
            throws BeansException {
        final Set<Field> annotatedFields = getAnnotatedFields(bean.getClass());
        for (Field annotatedField : annotatedFields) {
            LOG.info("Post process after initialization " + beanName + "," + annotatedField);
        }
        return bean;
    }

    private Set<Field> getAnnotatedFields(final Class<?> clazz) {
        final Set<Field> annotatedFields = new HashSet<Field>();
        for (Field field : clazz.getDeclaredFields()) {
            if(hasMyAnnotation(field)) {
                annotatedFields.add(field);
            }
        }
        return annotatedFields;
    }

    private boolean hasMyAnnotation(final AccessibleObject ao) {
        return AnnotationUtils.getAnnotation(ao, MyAnnotation.class) != null;
    }
}