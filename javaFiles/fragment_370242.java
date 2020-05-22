public SimpleKeyDeserializers addDeserializer(Class<?> forClass, KeyDeserializer deser)
{
    if (_classMappings == null) {
        _classMappings = new HashMap<ClassKey,KeyDeserializer>();
    }
    _classMappings.put(new ClassKey(forClass), deser);
    return this;
}