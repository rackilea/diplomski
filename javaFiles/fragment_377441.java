public class ConfigValueBeanProcessor implements BeanPostProcessor, FactoryBean<ConfigSupplier> {

  @Autowired
  private EnvironmentConfiguration environmentConfiguration;

  @Override
  public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
    if (bean.getClass().isAnnotationPresent(MyConfigurableMarkerAnnotationOnClassLevel.class)) {
      List<Field> annotatedFields = FieldUtils.getFieldsListWithAnnotation(bean.getClass(), ConfigurationValue.class);
      for (Field field : annotatedFields) {
        try {
          processAnnotatedField(field, bean);
        } catch (IllegalAccessException e) {
        // do stuff
        }
      }
    }
    return bean;
  }

  private void processAnnotatedField(Field field, Object bean) throws IllegalAccessException {
    boolean accessible = field.isAccessible();
    field.setAccessible(true);
    Object o = field.get(bean);
    if (o instanceof ConfigSupplier) {
      ConfigurationValue annotation = field.getAnnotation(ConfigurationValue.class);
      ConfigSupplier configSupplier = (ConfigSupplier) o;
      ConfigSupplier patchedSupplier = configSupplier.withSettingsKeyAndDefault(
          annotation.name(), annotation.defaultValue());
      field.set(bean, patchedSupplier);
    }
    field.setAccessible(accessible);
  }

  @Override
  public ConfigSupplier getObject() throws Exception {
    return new ConfigSupplier(environmentConfiguration);
  }

  @Override
  public Class<?> getObjectType() {
    return ConfigSupplier.class;
  }
}