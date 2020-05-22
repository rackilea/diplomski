@MessageDriven(                
        mappedName = "testEndpoint", // GlassFish    
        activationConfig = { 
            @ActivationConfigProperty(propertyName = "destination", 
                                      propertyValue = "testEndpoint"),  // Wildfly
            @ActivationConfigProperty(propertyName = "destinationType",                                                      
                                      propertyValue = "javax.jms.Topic")
    })