public CardDetailsResponse getCardDetails(User userDetails,String destination) {
        CardDetailsResponse cardDetailsResponse=new CardDetailsResponse();
     try    {

        HttpClient httpClient = new HttpClient();
        GetMethod get = new GetMethod("https://sriharicorp.com/sampleApplications/CoreIssue.aspx?serviceName=svc&loginStatus=1&accountNumber=32146546454");
        get.addRequestHeader("Content-Type", "application/json");
        try {
            httpClient.executeMethod(get);
            String response=get.getResponseBodyAsString();

            StreamSource responseStream = new StreamSource(new StringReader(response));

            JAXBContext jaxbContext = JAXBContext.newInstance(CardDetailsResponse.class);

            javax.xml.bind.Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

            cardDetailsResponse=(CardDetailsResponse)jaxbUnmarshaller.unmarshal(responseStream);

            System.out.println("object data = "+cardDetailsResponse.getCardListField().getCardDetailsField().getCardNumberField());

        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return cardDetailsResponse;
    }