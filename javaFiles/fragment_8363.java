Client client = ClientProxy.getClient(contractTermsDownloadPortType);
client.getOutInterceptors().add(new AbstractOutDatabindingInterceptor(Phase.MARSHAL) {

        public void handleFault(Message message) {
        }

        public void handleMessage(Message message) throws Fault {
            MetadataMap<String, Object> headers = new MetadataMap<String, Object>();
            headers.putSingle("authorization", "Basic User:Password2012");
            message.put(Message.PROTOCOL_HEADERS, headers);
        }
    });