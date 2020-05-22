public static void copyProperties(Object src, Object dest) throws IllegalAccessException,
        InvocationTargetException, NoSuchMethodException {

    java.util.Date defaultValue = null;
    Converter converter = new DateConverter(defaultValue);
    BeanUtilsBean beanUtilsBean = BeanUtilsBean.getInstance();
    beanUtilsBean.getConvertUtils().register(converter, java.util.Date.class);
    BeanUtils.copyProperties(dest, src);


}