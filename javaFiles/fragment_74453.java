public class CustomBeanSerializerModifier extends BeanSerializerModifier {

    @Override
    public List<BeanPropertyWriter> changeProperties(SerializationConfig config, 
           BeanDescription beanDesc, List<BeanPropertyWriter> beanProperties) {

        for (BeanPropertyWriter beanProperty : beanProperties) {
            if (beanProperty.getAnnotation(NAifNull.class) != null) {
                beanProperty.assignNullSerializer(new CustomNullSerializer());
            }
        }

        return beanProperties;
    }
}