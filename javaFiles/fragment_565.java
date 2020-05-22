class InsensitiveBeanDeserializerModifier extends BeanDeserializerModifier {

    @Override
    public JsonDeserializer<?> modifyDeserializer(DeserializationConfig config, BeanDescription beanDesc, JsonDeserializer<?> deserializer) {
        JsonDeserializer<?> base = super.modifyDeserializer(config, beanDesc, deserializer);
        if (base instanceof BeanDeserializer) {
            return new InsensitiveBeanDeserializer((BeanDeserializer) base);
        }

        return base;
    }
}

class InsensitiveBeanDeserializer extends BeanDeserializer {

    public InsensitiveBeanDeserializer(BeanDeserializerBase src) {
        super(src);
    }

    public Object deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        // common case first
        if (p.isExpectedStartObjectToken()) {
            if (_vanillaProcessing) {
                return vanillaDeserialize(p, ctxt, p.nextToken());
            }
            // 23-Sep-2015, tatu: This is wrong at some many levels, but for now... it is
            //    what it is, including "expected behavior".
            p.nextToken();
            if (_objectIdReader != null) {
                return deserializeWithObjectId(p, ctxt);
            }
            return deserializeFromObject(p, ctxt);
        }
        return _deserializeOther(p, ctxt, p.getCurrentToken());
    }

    protected Object vanillaDeserialize(JsonParser p, DeserializationContext ctxt, JsonToken t) throws IOException {
        final Object bean = _valueInstantiator.createUsingDefault(ctxt);
        // [databind#631]: Assign current value, to be accessible by custom serializers
        p.setCurrentValue(bean);
        Map<String, String> names = new HashMap<>();
        if (p.hasTokenId(JsonTokenId.ID_FIELD_NAME)) {
            String propName = p.getCurrentName();
            do {
                String oldName = names.put(propName.toLowerCase(), propName);
                if (oldName != null) {
                    String msg = "Properties '" + propName + "' and '" + oldName + "' are the same!";
                    throw new DuplicateInsensitiveKeysException(p, msg);
                }

                defaultImplementation(p, ctxt, bean, propName);
            } while ((propName = p.nextFieldName()) != null);
        }
        return bean;
    }

    private void defaultImplementation(JsonParser p, DeserializationContext ctxt, Object bean, String propName) throws IOException {
        p.nextToken();
        SettableBeanProperty prop = _beanProperties.find(propName);

        if (prop != null) { // normal case
            try {
                prop.deserializeAndSet(p, ctxt, bean);
            } catch (Exception e) {
                wrapAndThrow(e, bean, propName, ctxt);
            }
            return;
        }
        handleUnknownVanilla(p, ctxt, bean, propName);
    }

    public static class DuplicateInsensitiveKeysException extends JsonMappingException {

        public DuplicateInsensitiveKeysException(Closeable processor, String msg) {
            super(processor, msg);
        }
    }
}