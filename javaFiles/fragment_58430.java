@Bean
@ConditionalOnMissingBean(PojoCodec.class)
public PojoCodec codec() {
    Map<String, KryoRegistrar> kryoRegistrarMap = applicationContext.getBeansOfType(KryoRegistrar.class);
    return new PojoCodec(new ArrayList<>(kryoRegistrarMap.values()), kryoCodecProperties.isReferences());
}

@Bean
@ConditionalOnMissingBean(KryoRegistrar.class)
public KryoRegistrar fileRegistrar() {
    return new FileKryoRegistrar();
}