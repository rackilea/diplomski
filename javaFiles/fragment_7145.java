private String getUldStatePrivate(String uldNumber) throws SystemException {
    ProvideULDinformationRequest wsRequest = new ProvideULDinformationRequest();
    wsRequest.setIdcode(uldNumber);
    ProvideULDinformationResponse uldInfo = null;
    try {
        uldInfo = service.provideULDinformation(wsRequest);
    } catch (ProvideULDinformationBusinessException e) {
        e.printStackTrace();
    } 
    if (uldInfo != null) {
        return uldInfo.getUldPhysicalStatus();      
    }       
    return null;
}