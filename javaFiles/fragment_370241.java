public SimpleModule addKeyDeserializer(Class<?> type, KeyDeserializer deser)
{
    if (_keyDeserializers == null) {
        _keyDeserializers = new SimpleKeyDeserializers();
    }
    _keyDeserializers.addDeserializer(type, deser);
    return this;
}