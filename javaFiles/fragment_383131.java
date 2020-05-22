class UnitBeanSerializerModifier extends BeanSerializerModifier {

    @Override
    public List<BeanPropertyWriter> changeProperties(SerializationConfig config, BeanDescription beanDesc, List<BeanPropertyWriter> beanProperties) {
        for (int i = 0; i < beanProperties.size(); ++i) {
            final BeanPropertyWriter writer = beanProperties.get(i);
            AnnotatedMember member = writer.getMember();
            Unit units = member.getAnnotation(Unit.class);
            if (units != null) {
                beanProperties.set(i, new UnitBeanPropertyWriter(writer, units.value()));
            }
        }
        return beanProperties;
    }
}

class UnitBeanPropertyWriter extends BeanPropertyWriter {

    private final String unit;

    protected UnitBeanPropertyWriter(BeanPropertyWriter base, String unit) {
        super(base);
        this.unit = unit;
    }

    @Override
    public void serializeAsField(Object bean, JsonGenerator gen, SerializerProvider prov) throws Exception {
        gen.writeFieldName(_name);
        final Object value = (_accessorMethod == null) ? _field.get(bean) : _accessorMethod.invoke(bean, (Object[]) null);
        gen.writeString(value + " " + unit);
    }
}