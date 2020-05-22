@Configuration
class MessagesConfiguration {

    @Bean(name = "messageProperties")
    public static PropertiesFactoryBean mapper() {
        PropertiesFactoryBean bean = new PropertiesFactoryBean();
        bean.setLocation(new ClassPathResource("messages.properties"));
        return bean;
    }

    @Resource(name="messageProperties")
    private Properties messages = new Properties();

    public Properties getMessages() {
        return messages;
    }

}