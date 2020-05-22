SalesforceComponent component = new SalesforceComponent();
            final SalesforceEndpointConfig config = new SalesforceEndpointConfig();
            config.setApiVersion(System.getProperty("apiVersion", "28.0"));
            component.setConfig(config);

            SalesforceLoginConfig loginConfig = new SalesforceLoginConfig();
            loginConfig.setClientId("clientId");
            loginConfig.setClientSecret("ClientSecret");
            loginConfig.setUserName("username");
            loginConfig.setPassword("password");
            loginConfig.setLoginUrl("url");
            component.setLoginConfig(loginConfig);
            context.addComponent("salesforce", component);