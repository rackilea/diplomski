public class CustomSerializer extends JsonSerializer<Object> {

    private Class<?>[] _activeViews;

    public CustomSerializer(Class<?>[] view){
        _activeViews = view;
    }

    @Override
    public void serialize(Object value, JsonGenerator jgen,
            SerializerProvider provider) throws IOException,
            JsonProcessingException {

        BeanPropertyFilter filter = provider.getConfig().getFilterProvider().findFilter("CustomFilter");
        if(filter instanceof CustomFilter){
            CustomFilter customFilter = (CustomFilter) filter;

            // Tell the filter that we will filter our next property
            customFilter.setNextViews(_activeViews);

            provider.defaultSerializeValue(value, jgen);

            // Property has been filtered and written, do not filter anymore
            customFilter.setNextViews(null);
        }else{
            // You did not define a CustomFilter ? Well this serializer is useless...
            provider.defaultSerializeValue(value, jgen);
        }
    }
}