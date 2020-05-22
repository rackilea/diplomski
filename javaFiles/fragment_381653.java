@Bean
public MessageBrokerServlet messageBrokerServlet() {
    return new MessageBrokerServlet();
}

@Bean
public ServletRegistrationBean<MessageBrokerServlet> messageBrokerServletRegistration() {
    ServletRegistrationBean<MessageBrokerServlet> registration = 
        new ServletRegistrationBean(messageBrokerServlet(), "/messagebroker/*");        
    return registration;
}