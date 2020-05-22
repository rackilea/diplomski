public static void wireBeanFromProperties(Object bean, Properties props){

    BeanWrapper wrapper = new BeanWrapperImpl(bean);
    for(Entry<Object, Object> entry:props.entrySet()){
        String propertyName = entry.getKey().toString();
        if(wrapper.isWritableProperty(propertyName)){
            wrapper.setPropertyValue(propertyName, entry.getValue());
        }
    }

}