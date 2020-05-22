JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
           // This enables FastInfoset as the communication protocol
           factory.getInInterceptors().add( new FIStaxInInterceptor() );
           factory.getOutInterceptors().add( new FIStaxOutInterceptor() );
           ... other code to set username, location, etc. goes here.
           client = (C360Server) factory.create();