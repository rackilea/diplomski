public static void wireBeanFromProperties(final Object bean,
    final Properties props){
    final BeanWrapper wrapper = new BeanWrapperImpl(bean);
    // will throw an exception if the Properties object
    // contains any unknown keys
    wrapper.setPropertyValues(props);
}