Response response = (Response) webServiceTemplate
            .marshalSendAndReceive(
                    "http://www5v80.elsyarres.net/service.asmx",
                    searchFlights,
                    new WebServiceMessageCallback() {
                        public void doWithMessage(WebServiceMessage message) 
                        {
                            ((SoapMessage)message).setSoapAction("http://www5v80.elsyarres.net/searchFlights");
                        }
                   }
               );