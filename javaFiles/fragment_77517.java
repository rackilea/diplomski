@Bean
public Module dynamoDemoEntityDeserializer() {
    SimpleModule module = new SimpleModule();
    module.addDeserializer(IDemoEntity.class, new DynamoDemoEntityDeserializer());
    return module;
}