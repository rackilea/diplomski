HttpTransportProperties.Authenticator
                       auth = new HttpTransportProperties.Authenticator();
            auth.setUsername("username");
            auth.setPassword("password");

 _serviceClient.getOptions().setProperty(org.apache.axis2.transport.http.HTTPConstants.BASIC_AUTHENTICATE,auth);