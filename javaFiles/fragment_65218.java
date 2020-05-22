from("cxf:bean:brokerOrderLimit?dataFormat=PAYLOAD&allowStreaming=false")
            .process(soapHeadersEnricher)
            .onException(SoapFault.class)
            .onWhen(bLoginExceptionPredicate)
            .handled(false) // return fault to client
            .maximumRedeliveries(2)
            .redeliveryDelay(5000) 
            .retryAttemptedLogLevel(LoggingLevel.WARN)
            .logHandled(false)
            .onRedelivery(soapHeadersEnricher)
            .end()
            .to("cxf:bean:bOrderLimit?dataFormat=PAYLOAD&allowStreaming=false")
            .process(new Processor() {
                @Override
                public void process(Exchange exchange) throws Exception {
                    AccessKey accessKey = exchange.getProperty(BSoapHeadersEnricher.ACCESKEY_PROPERTY, AccessKey.class);
                    accessKeyProvider.returnAccessKey(accessKey);
                }
            });