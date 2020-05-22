private Class<?> getClass(String column) {
    PropertyDescriptor[] pds = BeanUtils.getPropertyDescriptors(this.mappedClass);
    for (PropertyDescriptor pd : pds) {
        if (pd.getName().equals(column)) {
            return pd.getPropertyType();
        }
    }
    return null;
}