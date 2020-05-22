@Bean
public ListenerContainerCustomizer<AbstractMessageListenerContainer<byte[], byte[]>> customizer() {
    return (container, dest, group) -> {
        KafkaTransactionManager<?, ?> tm = (KafkaTransactionManager<?, ?>) container.getContainerProperties()
                .getTransactionManager();
        tm.setTransactionSynchronization(AbstractPlatformTransactionManager.SYNCHRONIZATION_ON_ACTUAL_TRANSACTION);
    };
}