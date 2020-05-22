public static class CustomFilter extends SimpleBeanPropertyFilter {

    private Class<?>[] _nextViews;

    public void setNextViews(Class<?>[] clazz){
        _nextViews = clazz;
    }

    @Override
    public void serializeAsField(Object bean, JsonGenerator jgen,
            SerializerProvider prov, BeanPropertyWriter writer)
            throws Exception {

        Class<?>[] propViews = writer.getViews();

        if(propViews != null && _nextViews != null){
            for(Class<?> propView : propViews){
                System.out.println(propView.getName());
                for(Class<?> currentView : _nextViews){
                    if(!propView.isAssignableFrom(currentView)){
                        // Do the filtering!
                        return;
                    }
                }
            }
        }
        // The property is not filtered
        writer.serializeAsField(bean, jgen, prov);
    }
}