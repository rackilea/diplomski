getMockEndpoint("mock:exception").whenAnyExchangeReceived(new 
Processor() { 

            @Override 
            public void process(Exchange exchange) throws Exception { 
                throw new Exception("fail me"); 
            } 
        });