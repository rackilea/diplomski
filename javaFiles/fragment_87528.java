private static final String TARGET_NAMESPACE = "http://www.swisscom.com/wsg/bb/v42";

    @PayloadRoot(namespace = "http://www.swisscom.com/wsg/bb/v42", localPart = "getAddressRequest")
    @ResponsePayload
    public GetAddressResponse getAddressRequest(@RequestPayload GetAddressRequest request, MessageContext messageContext) throws DatatypeConfigurationException, JAXBException {

        //Create Response Body and Header
        SaajSoapMessage soapResponse = (SaajSoapMessage) messageContext.getResponse();
        SoapHeader soapResponseHeader = soapResponse.getSoapHeader();

        //New UsernameHeader Object
        UsernameHeader usernameToken = new UsernameHeader();

        //Set UsernameHeader Object values
        usernameToken.setUsername("SandyAPI");
        usernameToken.setPassword("Test_Password");

        //Create SecurityHeader Object that will contain the UsernameHeader Object
        SecurityHeader securityHeader = new SecurityHeader();
        securityHeader.setUsernameHeader(usernameToken);

        //Genetare random UUID
        UUID uuid = UUID.randomUUID();

        //Create new GetAddressResponse Object and set the values (body)
        GetAddressResponse response = new GetAddressResponse();
        response.setAddress(addressService.getAddress(request.getCity())); //Get the city from AddressService method by passing as parameter the city of the request obj
        response.setDnType(DnType.BBCS_QUALIFY.getType());
        response.setBasisContrEleId(BasisContrEleId.BBCS_BASISCONTR.getType());
        response.setBbType(BbType.BBCS_BBTYPE.getType());
        response.setContrEleId(ContrEleId.BBCS_CONTRELE.getType());
        response.setIspId(Integer.parseInt(configProperties.getConfigValue("ispId")));
        response.setQualifExtRef(uuid.toString());
        response.setReturnSpeedAtNok(Boolean.TRUE);
        response.setSfSlaId(SetSfSlaId.FIRST_POSSIBLE.getType());
        GregorianCalendar gcal = new GregorianCalendar();
        XMLGregorianCalendar xgcal = DatatypeFactory.newInstance()
                .newXMLGregorianCalendar(gcal);
        response.setCustomerWishDate(xgcal);


        //Send Response back (Classes marshalled)
        JAXBContext jaxbContext = JAXBContext.newInstance(SecurityHeader.class);
        jaxbContext.createMarshaller().marshal(securityHeader, soapResponseHeader.getResult());

        return response;

    }