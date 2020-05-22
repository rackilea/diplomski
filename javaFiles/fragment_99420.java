private void sendNextRequest(int enumType) throws InternalException, IllegalDiameterStateException, RouteException, OverloadException {
    Request r = this.session.createRequest(commandCode, this.authAppId, realmName);
    AvpSet requestAvps = r.getAvps();
    Avp exchangeType = requestAvps.addAvp(exchangeTypeCode, (long) enumType, vendorID, true, false, true);
    Avp exchengeData = requestAvps.addAvp(exchangeDataCode, TO_SEND[toSendIndex++], vendorID, true, false, false); 
    requestAvps.addAvp(Avp.DESTINATION_HOST, "127.0.0.1", true, false, true);
    this.session.send(r, this);
    dumpMessage(r,true);
}