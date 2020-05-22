@Bean
public MySource source() {
    // return my subclass of MessageProducer that has outputChannel injected
    // and calls sendMessage
    // or use a simple POJO that uses MessagingTemplate.convertAndSend(foo)
}